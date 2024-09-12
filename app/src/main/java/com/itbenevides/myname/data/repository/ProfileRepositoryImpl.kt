package com.itbenevides.myname.data.repository

import com.itbenevides.myname.data.model.Profile
import com.itbenevides.myname.data.remote.RemoteDataSource
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor(
    private val remoteProfileDataSource: RemoteDataSource,
): ProfileRepository {
    override suspend fun getProfileData(): Profile {
       val response = remoteProfileDataSource.getProfileDataResponse()
        val name = response.name
        return Profile(name = name)
    }
}