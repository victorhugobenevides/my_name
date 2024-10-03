package com.itbenevides.myname.data.repository


import com.itbenevides.myname.data.model.Profile
import rx.Observable


interface ProfileRepository {
     suspend fun getProfileData(): Observable<Profile>
}