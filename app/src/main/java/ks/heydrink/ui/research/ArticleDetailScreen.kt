package ks.heydrink.ui.research

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import ks.heydrink.data.repository.ArticlesRepositoryImpl

@Composable
fun ArticleDetailScreen(articleId: String?, navController: NavController) {
    val context = LocalContext.current.applicationContext
    val repo = androidx.compose.runtime.remember { ArticlesRepositoryImpl(context) }
    val vm: ResearchViewModel = viewModel(factory = ResearchViewModelFactory(repo))

    val articles by vm.articles.collectAsState()
    val article = androidx.compose.runtime.remember(articles, articleId) {
        articles.firstOrNull { it.id == articleId }
    }

    if (article == null) {
        Text(
            text = "Статья не найдена",
            modifier = Modifier.padding(16.dp),
            style = MaterialTheme.typography.bodyMedium
        )
        return
    }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = article.title,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 12.dp)
        )

        article.sections.forEach { section ->
            section.subtitle?.let { subtitle ->
                Text(
                    text = subtitle,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 4.dp, top = 8.dp)
                )
            }
            Text(
                text = section.content,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }
    }
}