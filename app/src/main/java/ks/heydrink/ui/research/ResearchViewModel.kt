package ks.heydrink.ui.research

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable
import ks.heydrink.data.repository.ArticlesRepositoryImpl
import ks.heydrink.domain.model.Article
import ks.heydrink.domain.repository.ArticlesRepository
import javax.inject.Inject

@HiltViewModel
class ResearchViewModel @Inject constructor(private val repository: ArticlesRepository) : ViewModel() {

    private val _articles = MutableStateFlow<List<Article>>(emptyList())

    init {
        loadArticles()
    }

    fun loadArticles() {
        viewModelScope.launch {
            try {
                val list = repository.getArticles()
                _articles.value = list
                println("Loaded articles: ${list.size}")
                list.forEach { println("→ ${it.id}: ${it.title}") }
            } catch (t: Throwable) {
                println("Error loading articles: ${t.message}")
                _articles.value = emptyList()
            }
        }
    }

    fun getArticleById(id: String?): Article? {
        if (id == null) return null
        else {
            return _articles.value.firstOrNull { it.id == id }
        }
    }

    fun getNextArticle(currentId: String?): Article? {
        if (currentId == null) return null
        val list = _articles.value
        val index = list.indexOfFirst { it.id == currentId }
        return if (index != -1 && index < list.lastIndex) {
            list[index + 1]
        } else {
            null
        }
    }
}