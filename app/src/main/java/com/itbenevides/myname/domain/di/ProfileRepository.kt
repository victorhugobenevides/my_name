package com.itbenevides.myname.domain.di

import com.itbenevides.myname.data.model.Profile

interface ProfileRepository {
    suspend fun getProfileData(): Profile
}