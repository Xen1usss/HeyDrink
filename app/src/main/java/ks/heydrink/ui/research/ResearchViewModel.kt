package ks.heydrink.ui.research

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ks.heydrink.domain.model.Article
import ks.heydrink.domain.repository.ArticlesRepository

class ResearchViewModel(private val repository: ArticlesRepository) : ViewModel() {

    private val _articles = MutableStateFlow<List<Article>>(emptyList())
    val articles: StateFlow<List<Article>> = _articles

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
}

class ResearchViewModelFactory(
    private val repository: ArticlesRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ResearchViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ResearchViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
    }
}

