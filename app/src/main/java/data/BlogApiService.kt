package data

import retrofit2.http.GET
import retrofit2.http.Query

interface BlogApiService {
    @GET("posts")
    suspend fun getBlogPosts(
        @Query("per_page") perPage: Int = 10,
        @Query("page") page: Int
    ): List<BlogPost>
}
