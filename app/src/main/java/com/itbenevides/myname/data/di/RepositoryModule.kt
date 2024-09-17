package com.itbenevides.myname.data.di

import com.itbenevides.myname.domain.di.ProfileRepository
import com.itbenevides.myname.data.repository.ProfileRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    @Singleton
    fun bindProfileRepository(repository: ProfileRepositoryImpl): ProfileRepository
}