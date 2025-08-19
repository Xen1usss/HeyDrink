package ks.heydrink.domain.model

data class ResearchArticle(
    val id: String,
    val questionRu: String,
    val questionEn: String,
    val contentRu: String,
    val contentEn: String,
    val references: List<String>
)
