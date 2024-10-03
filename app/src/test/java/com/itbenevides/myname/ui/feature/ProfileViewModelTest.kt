package com.itbenevides.myname.ui.feature

import com.itbenevides.myname.data.model.Profile
import com.itbenevides.myname.data.repository.ProfileRepository
import com.itbenevides.myname.ui.feature.profile.ProfileViewModel
import io.mockk.coEvery
import io.mockk.mockk
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test


class ProfileViewModelTest {

    private lateinit var repository: ProfileRepository
    private lateinit var viewModel: ProfileViewModel
    private val profile = Profile(name = "Victor Hugo Benevides Sobrinho", yearOfBirth = 1989)


    @Before
    fun setup(){
        repository = mockk<ProfileRepository>()
    }

    @Test
    fun `when get profile data`() {
        coEvery { repository.getProfileData() } returns profile
        viewModel = ProfileViewModel(repository)
        val profileResult = viewModel.profileInfoState.value.data as Profile
        assertEquals(profile, profileResult)

    }
}