package repository

import data.BlogPost
import data.RetrofitInstance
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class BlogRepository {
    private val api = RetrofitInstance.api

    fun getBlogPosts(page: Int): Flow<List<BlogPost>> = flow {
        emit(api.getBlogPosts(page = page))
    }
}
