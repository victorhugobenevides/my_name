package com.itbenevides.myname.data.repository

import com.itbenevides.myname.data.remote.RemoteDataSource
import javax.inject.Inject

class NameRepositoryImpl @Inject constructor(
    private val remoteNameDataSource: RemoteDataSource,
): NameRepository {
    override suspend fun getNameData(): String {
       val response = remoteNameDataSource.getNameDataResponse()
        val name = response.name

        return name
    }
}