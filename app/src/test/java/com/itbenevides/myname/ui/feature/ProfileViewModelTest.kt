import android.arch.core.executor.testing.InstantTaskExecutorRule
import com.itbenevides.myname.data.model.Profile
import com.itbenevides.myname.data.repository.ProfileRepository
import com.itbenevides.myname.ui.feature.profile.ProfileViewModel
import com.itbenevides.myname.ui.feature.profile.StatusResult
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.setMain
import kotlinx.coroutines.test.resetMain
import io.mockk.coEvery
import io.mockk.clearAllMocks
import io.mockk.mockk
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.Assert.*
import kotlinx.coroutines.Dispatchers

@OptIn(ExperimentalCoroutinesApi::class)
class ProfileViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var profileViewModel: ProfileViewModel

    private val profileRepository: ProfileRepository = mockk()

    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        coEvery { profileRepository.getProfileData() } returns Profile(name = "Test User", yearOfBirth = 1990)
        profileViewModel = ProfileViewModel(profileRepository)
    }

    @After
    fun tearDown() {
        clearAllMocks()
        Dispatchers.resetMain()
    }

    @Test
    fun `should update state to Loading initially`() = runTest {

        coEvery { profileRepository.getProfileData() } returns Profile(name = "Test User", yearOfBirth = 1990)
        profileViewModel = ProfileViewModel(profileRepository)

        val loadingState = profileViewModel.profileInfoState.take(1).first()

        assertEquals(StatusResult.Loading, loadingState.status)

        advanceUntilIdle()
    }

    @Test
    fun `should update state to Success when profile is loaded successfully`() = runTest {

        coEvery { profileRepository.getProfileData() } returns Profile(name = "Test User", yearOfBirth = 1990)
        profileViewModel = ProfileViewModel(profileRepository)

        advanceUntilIdle()

        val result = profileViewModel.profileInfoState.take(1).first()

        assertEquals(StatusResult.Success, result.status)
        assertEquals("Test User", (result.data as Profile).name)
    }

    @Test
    fun `should update state to Error when profile loading fails`() = runTest {
        coEvery {  profileRepository.getProfileData() } throws RuntimeException("Network Error")
        profileViewModel = ProfileViewModel(profileRepository)

        advanceUntilIdle()
        advanceUntilIdle()

        val result = profileViewModel.profileInfoState.take(1).first()

        println("State: ${result.status}, Message: ${result.data}")

        assertEquals(StatusResult.Error, result.status)
        assertEquals("Network Error", result.data)
    }
}
