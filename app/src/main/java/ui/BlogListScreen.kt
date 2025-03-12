package ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.navigation.NavController
import data.BlogPost
import viewmodel.BlogViewModel
import androidx.compose.ui.unit.dp
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Composable
fun BlogListScreen(navController: NavController, viewModel: BlogViewModel) {
    val blogs by viewModel.blogs.collectAsState(initial = emptyList())
    LazyColumn {
        items(blogs) { blog ->
            BlogItem(blog) {
                val encodedUrl = URLEncoder.encode(blog.link, StandardCharsets.UTF_8.toString())
                navController.navigate("details/$encodedUrl")
            }
        }
    }
}

@Composable
fun BlogItem(blog: BlogPost, onClick: () -> Unit) {
    Card(
        modifier = androidx.compose.ui.Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() },
        elevation = 4.dp
    ) {
        Column(modifier = androidx.compose.ui.Modifier.padding(16.dp)) {
            Text(text = blog.title.rendered, style = MaterialTheme.typography.h6)
        }
    }
}
