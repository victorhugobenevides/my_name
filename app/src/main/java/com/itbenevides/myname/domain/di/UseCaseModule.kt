package com.itbenevides.myname.domain.di

import com.itbenevides.myname.domain.ProfileUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
interface UseCaseModule {
    @Binds
    fun bindUseCaseDataSource(useCaseDataSource: ProfileUseCaseImpl) : ProfileUseCase
}