package com.ozman.test.di

import com.ozman.test.data.remote.ApiService
import com.ozman.test.data.reposeimp.PostRepositoryImpl
import com.ozman.test.domain.reposint.PostRepository
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
    fun provideReposService(apiService: ApiService): PostRepository {
        return PostRepositoryImpl(apiService)
    }
}