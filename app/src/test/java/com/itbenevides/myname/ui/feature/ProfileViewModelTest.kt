package com.itbenevides.myname.ui.feature

import com.itbenevides.myname.data.model.Profile
import com.itbenevides.myname.data.repository.ProfileRepository
import com.itbenevides.myname.settings.Dispatchers
import com.itbenevides.myname.ui.feature.name.ProfileViewModel
import org.junit.Assert.assertEquals
import org.junit.Test


class ProfileViewModelTest: Dispatchers() {

    private lateinit var viewModel: ProfileViewModel
    @Test
    fun get_profile_success(){
        viewModel = ProfileViewModel(MockProfileRepository())
        val profile = viewModel.profileInfoState.value.profile
        assertEquals(Profile(name = "Pipoca doce"), profile)
    }
}

class MockProfileRepository : ProfileRepository {
    override suspend fun getProfileData(): Profile {
        return Profile(name = "Pipoca doce")
    }
}