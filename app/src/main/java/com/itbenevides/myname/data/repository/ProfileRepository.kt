package com.itbenevides.myname.data.repository

import com.itbenevides.myname.data.model.Profile

interface ProfileRepository {
    suspend fun getProfileData(): Profile
}