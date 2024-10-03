package com.itbenevides.myname.data.remote

import com.itbenevides.myname.data.remote.response.ProfileDataResponse
import retrofit2.http.GET
import rx.Observable


interface APIService {

    @GET("profile")
    fun getProfileDataResponse(): Observable<ProfileDataResponse>
}