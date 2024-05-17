package com.ozman.test.data.reposeimp


import com.ozman.test.data.remote.ApiService
import com.ozman.test.data.remote.response.LoginResponse
import com.ozman.test.domain.reposint.LoginRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : LoginRepository {
    override fun login(username: String, password: String): Flow<LoginResponse> = flow {
        if(username=="test"&&password=="test")
        emit(LoginResponse(true, "success"))
        else
            emit(LoginResponse(false, "error"))

    }.flowOn(Dispatchers.IO)
}
