package viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import data.BlogPost
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import repository.BlogRepository

class BlogViewModel : ViewModel() {
    private val repository = BlogRepository()
    private val _blogs = MutableStateFlow<List<BlogPost>>(emptyList())
    val blogs: StateFlow<List<BlogPost>> = _blogs

    init {
        fetchBlogs()
    }

    fun fetchBlogs(page: Int = 1) {
        viewModelScope.launch {
            repository.getBlogPosts(page).collect { posts ->
                _blogs.value = _blogs.value + posts
            }
            Log.d("BlogViewModel", "Blogs received: $blogs")
        }
    }
}
