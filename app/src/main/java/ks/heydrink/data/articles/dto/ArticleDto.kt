package ks.heydrink.data.articles.dto

data class ArticleDto(
    val id: String,
    val title: String,
    val sections: List<SectionDto>
)

data class SectionDto(
    val subtitle: String?,
    val content: String
)