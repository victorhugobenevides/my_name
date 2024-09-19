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
    private val profile = Profile(name = "Victor Hugo Benevides Sobrinho", yearOfBirth = 1989)


    @Before
    fun setup(){
        Dispatchers.setMain(Dispatchers.Unconfined)
        repository = mockk<ProfileRepository>()
    }

    @Test
    fun `when get profile data`() = runTest{
        coEvery { repository.getProfileData() } returns profile
        viewModel = ProfileViewModel(repository)
        val profileResult = viewModel.profileInfoState.value.data as Profile
        assertEquals(profile, profileResult)

    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
}