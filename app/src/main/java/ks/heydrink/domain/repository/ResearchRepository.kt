package ks.heydrink.domain.repository

import ks.heydrink.domain.model.ResearchArticle

interface ResearchRepository {
    suspend fun getArticles(): List<ResearchArticle>
}