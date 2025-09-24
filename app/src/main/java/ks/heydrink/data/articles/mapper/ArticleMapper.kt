package ks.heydrink.data.articles.mapper

import ks.heydrink.data.articles.dto.ArticleDto
import ks.heydrink.data.articles.dto.SectionDto
import ks.heydrink.domain.model.Article
import ks.heydrink.domain.model.ArticleSection

fun ArticleDto.toDomain(): Article {
    return Article(
        id = id,
        title = title,
        sections = sections.map { it.toDomain() }
    )
}

fun SectionDto.toDomain(): ArticleSection {
    return ArticleSection(
        subtitle = subtitle,
        content = content
    )
}
