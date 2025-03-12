package navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ui.BlogDetailsScreen
import ui.BlogListScreen
import viewmodel.BlogViewModel
import java.net.URLDecoder
import java.nio.charset.StandardCharsets

@Composable
fun BlogApp(viewModel: BlogViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "list") {
        composable("list") { BlogListScreen(navController, viewModel) }
        composable("details/{url}") { backStackEntry ->
            val encodedUrl = backStackEntry.arguments?.getString("url") ?: ""
            val url = URLDecoder.decode(encodedUrl, StandardCharsets.UTF_8.toString()) // ✅ Fixed issue
            BlogDetailsScreen(url)
        }
    }
}
