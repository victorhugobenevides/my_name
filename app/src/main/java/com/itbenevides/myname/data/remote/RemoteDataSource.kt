package com.itbenevides.myname.data.remote

import com.itbenevides.myname.data.remote.response.NameDataResponse

interface RemoteDataSource {
    suspend fun getNameDataResponse(): NameDataResponse
}