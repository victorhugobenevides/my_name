package com.itbenevides.myname.ui.feature

import com.itbenevides.myname.data.model.Profile
import com.itbenevides.myname.data.repository.ProfileRepository
import com.itbenevides.myname.ui.feature.profile.ProfileViewModel
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class ProfileViewModelTest {

    private lateinit var repository: ProfileRepository
    private lateinit var viewModel: ProfileViewModel



    @Before
    fun setup(){
        Dispatchers.setMain(Dispatchers.Unconfined)
        repository = mockk<ProfileRepository>()
    }

    @Test
    fun `test get profile data`() = runTest{
        val profile = Profile(name = "Victor")

        coEvery { repository.getProfileData() } returns profile
        viewModel = ProfileViewModel(repository)

        val result = viewModel.profileInfoState.value.profile
        assertEquals(profile, result)

    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
}