package ks.heydrink.domain.repository

import ks.heydrink.domain.model.Article

interface ArticlesRepository {
    suspend fun getArticles(): List<Article>
}