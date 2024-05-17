package com.ozman.test.di

import com.ozman.test.data.remote.ApiService
import com.ozman.test.data.reposeimp.LoginRepositoryImpl
import com.ozman.test.domain.reposint.LoginRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ReposModule {

    @Provides
    @Singleton
    fun provideReposService(apiService: ApiService): LoginRepository {
        return LoginRepositoryImpl(apiService)
    }
}