package ks.heydrink.ui.research

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import ks.heydrink.data.repository.ArticlesRepositoryImpl
import ks.heydrink.domain.model.Article

@Composable
fun ScienceScreen(navController: NavController) {
    val context = LocalContext.current.applicationContext
    val repo = androidx.compose.runtime.remember { ArticlesRepositoryImpl(context) }
    val vm: ResearchViewModel = viewModel(factory = ResearchViewModelFactory(repo))
    val articles by vm.articles.collectAsState()

    ArticleList(
        articles = articles,
        onArticleClick = { articleId ->
            navController.navigate("article/$articleId")
        }
    )
}

@Composable
private fun ArticleList(
    articles: List<Article>,
    onArticleClick: (String) -> Unit
) {
    LazyColumn {
        items(articles) { article ->
            ArticleCard(article = article, onClick = { onArticleClick(article.id) })
        }
    }
}

@Composable
private fun ArticleCard(article: Article, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(text = article.title, style = MaterialTheme.typography.titleMedium)
            val excerpt = article.sections.firstOrNull()?.content ?: ""
            Text(
                text = excerpt,
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(top = 6.dp)
            )
        }
    }
}