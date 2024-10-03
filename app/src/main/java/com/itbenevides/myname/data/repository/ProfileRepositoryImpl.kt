package com.itbenevides.myname.data.repository


import com.itbenevides.myname.data.model.Profile
import com.itbenevides.myname.data.remote.APIService
import rx.schedulers.Schedulers
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor(
    private val apiService: APIService
): ProfileRepository {
    override suspend fun getProfileData(): Profile {

       val response =
           apiService
               .getProfileDataResponse()
               .map{
                       Profile(
                           name = it.name,
                           yearOfBirth = it.yearOfBirth
                       )
               }
               .subscribeOn(Schedulers.io())
               .toBlocking()
               .single()

        return response

    }
}