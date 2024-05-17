package com.ozman.test.data.reposeimp


import com.ozman.test.data.remote.ApiService
import com.ozman.test.domain.model.Post
import com.ozman.test.domain.reposint.PostRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : PostRepository {
    override fun getPost(): Flow<List<Post>> = flow {
        val posts = apiService.getPosts()
        emit(posts)
    }
}
