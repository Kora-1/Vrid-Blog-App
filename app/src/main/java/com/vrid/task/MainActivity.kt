package com.vrid.task

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vrid.task.ui.theme.VridTaskTheme
import navigation.BlogApp
import viewmodel.BlogViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            VridTaskTheme {
//                Surface(color = MaterialTheme.colorScheme.background) {
//                    Greeting("Compose")
//                }
//            }
            val viewModel: BlogViewModel = viewModel()
            BlogApp(viewModel)
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello, $name!")
}
