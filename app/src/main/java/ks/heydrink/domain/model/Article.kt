package ks.heydrink.domain.model

data class Article(
    val id: String,
    val title: String,
    val sections: List<ArticleSection>
)

data class ArticleSection(
    val subtitle: String?,
    val content: String
)
