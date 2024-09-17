package com.itbenevides.myname.presenter.feature.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.itbenevides.myname.data.model.Profile
import com.itbenevides.myname.domain.di.ProfileUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val profileUseCase: ProfileUseCase
) : ViewModel() {

    private val _profileInfoState = MutableStateFlow(ProfileInfoState(Profile("")))
    val profileInfoState: StateFlow<ProfileInfoState> = _profileInfoState.asStateFlow()

    init {
        getProfileInfo()
    }

    private fun getProfileInfo(){
        viewModelScope.launch {
            try {
                val profileInfo = profileUseCase.getProfileData()
                _profileInfoState.update {
                    it.copy(profile = profileInfo)
                }
            }catch (_:Exception){

            }

        }
    }

}