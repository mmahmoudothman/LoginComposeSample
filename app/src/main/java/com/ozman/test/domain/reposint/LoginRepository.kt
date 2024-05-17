package com.ozman.test.domain.reposint

import com.ozman.test.data.remote.response.LoginResponse
import kotlinx.coroutines.flow.Flow

interface LoginRepository {
    fun login(username: String, password: String): Flow<LoginResponse>
}