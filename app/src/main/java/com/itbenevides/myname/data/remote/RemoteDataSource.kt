package com.itbenevides.myname.data.remote

import com.itbenevides.myname.data.remote.response.ProfileDataResponse

interface RemoteDataSource {
    suspend fun getProfileDataResponse(): ProfileDataResponse
}