package com.itbenevides.myname.data.di

import com.itbenevides.myname.data.repository.NameRepository
import com.itbenevides.myname.data.repository.NameRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface RepositoryModule {
    @Binds
    fun bindNameRepository(repository: NameRepositoryImpl): NameRepository
}