package com.itbenevides.myname.data

import com.itbenevides.myname.data.remote.RemoteDataSource
import com.itbenevides.myname.data.remote.response.NameDataResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import javax.inject.Inject

class KtorRemoteDataSource @Inject constructor(
    private val httpClient: HttpClient
) : RemoteDataSource{
    companion object {
        private const val BASE_URL = "https://api.mockfly.dev/mocks/6d0d6b70-b6e7-4b6a-bbd1-38c110541a04"
    }
    override suspend fun getNameDataResponse(): NameDataResponse {
        return httpClient
            .get("${BASE_URL}/name")
            .body()
    }
}