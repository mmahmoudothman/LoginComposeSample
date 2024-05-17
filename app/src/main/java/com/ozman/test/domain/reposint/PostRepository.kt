package com.ozman.test.domain.reposint

import com.ozman.test.domain.model.Post
import kotlinx.coroutines.flow.Flow

interface PostRepository {
     fun getPost(): Flow<List<Post>>
}