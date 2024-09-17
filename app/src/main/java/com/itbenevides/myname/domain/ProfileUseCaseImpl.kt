package com.itbenevides.myname.domain

import com.itbenevides.myname.data.model.Profile
import com.itbenevides.myname.domain.di.ProfileRepository
import com.itbenevides.myname.domain.di.ProfileUseCase
import javax.inject.Inject

class ProfileUseCaseImpl @Inject constructor(
    private val profileRepository: ProfileRepository,
): ProfileUseCase {
    override suspend fun getProfileData(): Profile {
       val response = profileRepository.getProfileData()
        val name = response.name
        return Profile(name = name)
    }
}