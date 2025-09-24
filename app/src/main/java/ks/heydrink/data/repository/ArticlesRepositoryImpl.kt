package ks.heydrink.data.repository

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext
import ks.heydrink.data.articles.dto.ArticleDto
import ks.heydrink.data.articles.mapper.toDomain
import ks.heydrink.domain.model.Article
import ks.heydrink.domain.repository.ArticlesRepository
import java.util.Locale

class ArticlesRepositoryImpl(
    private val context: Context // контекст нужен для доступа к файлам assets
) : ArticlesRepository {

    private val gson = Gson()
    private val cacheMutex = Mutex()
    private var cachedArticles: List<Article>? = null

    override suspend fun getArticles(): List<Article> {

        cachedArticles?.let { return it }

        return cacheMutex.withLock {

            cachedArticles?.let { return@withLock it }

            val lang = Locale.getDefault().language

            val filename = when (lang.lowercase(Locale.getDefault())) {
                "ru", "ru_ru" -> "articles_ru.json"
                else -> "articles_en.json"
            }

            val jsonText: String = try {
                withContext(Dispatchers.IO) {
                    context.assets.open(filename).bufferedReader().use { it.readText() }
                }
            } catch (e: Exception) {
                Log.e("ArticlesRepo", "Failed to read $filename from assets", e)
                return@withLock emptyList()
            }

            val dtoList: List<ArticleDto> = try { // Парсим JSON в DTO-объекты
                val listType = object : TypeToken<List<ArticleDto>>() {}.type
                gson.fromJson(jsonText, listType)
            } catch (e: Exception) {
                Log.e("ArticlesRepo", "Failed to parse JSON from $filename", e)
                return@withLock emptyList()
            }

            val domainList: List<Article> =
                dtoList.map { it.toDomain() } // Маппим DTO -> domain и кешируем
            cachedArticles = domainList

            domainList
        }
    }
}

/**
 * Реализация репозитория статей, читающая JSON из assets.
 * - Передавайте ApplicationContext в конструктор (context.applicationContext),
 *   чтобы избежать утечек Activity.
 * - Кеширует результат в памяти (cachedArticles) и защищает доступ через Mutex.
 */