package com.itbenevides.myname.ui.feature.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.itbenevides.myname.data.model.Profile
import com.itbenevides.myname.data.repository.ProfileRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val profileRepository: ProfileRepository
) : ViewModel() {

    private val _profileInfoState = MutableStateFlow(
        ProfileInfoState(
            profile =  Profile("", 0),
            result = StatusResult.Success
        )
    )
    val profileInfoState: StateFlow<ProfileInfoState> =
        _profileInfoState.asStateFlow()

    init {
        loading()
        getProfileInfo()
    }

    private fun getProfileInfo(){
        viewModelScope.launch {
            try {
                val profileInfo =
                    profileRepository.getProfileData()
                _profileInfoState.update {
                    it.copy(profile = profileInfo,result = StatusResult.Success)
                }
            }catch (_:Exception){
                _profileInfoState.update {
                    it.copy(result = StatusResult.Error)
                }

            }
        }
    }

    private fun loading(){
        _profileInfoState.update {
            it.copy(result = StatusResult.Loading)
        }
    }
}