package com.itbenevides.myname.data.repository


import com.itbenevides.myname.data.model.Profile
import com.itbenevides.myname.data.remote.APIService
import rx.Observable
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor(
    private val apiService: APIService
): ProfileRepository {
    override suspend fun getProfileData(): Observable<Profile> {

       val response =
           apiService
               .getProfileDataResponse()
               .map{
                       Profile(
                           name = it.name,
                           yearOfBirth = it.yearOfBirth
                       )
               }

        return response

    }
}