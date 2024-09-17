package com.itbenevides.myname.domain.di

import com.itbenevides.myname.data.model.Profile

interface ProfileUseCase {
    suspend fun getProfileData(): Profile
}