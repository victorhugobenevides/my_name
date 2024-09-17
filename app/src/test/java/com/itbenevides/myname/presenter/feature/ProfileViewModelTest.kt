package com.itbenevides.myname.presenter.feature

import com.itbenevides.myname.data.model.Profile
import com.itbenevides.myname.domain.di.ProfileUseCase
import com.itbenevides.myname.settings.Dispatchers
import com.itbenevides.myname.presenter.feature.profile.ProfileViewModel
import org.junit.Assert.assertEquals
import org.junit.Test


class ProfileViewModelTest: Dispatchers() {

    private lateinit var viewModel: ProfileViewModel
    @Test
    fun get_profile_success(){
        viewModel = ProfileViewModel(MockProfileUseCase())
        val profile = viewModel.profileInfoState.value.profile
        assertEquals(Profile(name = "Pipoca doce"), profile)
    }
}

class MockProfileUseCase : ProfileUseCase {
    override suspend fun getProfileData(): Profile {
        return Profile(name = "Pipoca doce")
    }
}