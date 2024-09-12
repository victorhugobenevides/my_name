package com.itbenevides.myname.data.di

import com.itbenevides.myname.data.repository.ProfileRepository
import com.itbenevides.myname.data.repository.ProfileRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface RepositoryModule {
    @Binds
    fun bindProfileRepository(repository: ProfileRepositoryImpl): ProfileRepository
}