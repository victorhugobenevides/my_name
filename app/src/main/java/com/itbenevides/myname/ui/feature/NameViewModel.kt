package com.itbenevides.myname.ui.feature

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.itbenevides.myname.data.repository.NameRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NameViewModel @Inject constructor(
    private val nameRepository: NameRepository
) : ViewModel() {

    private val _nameInfoState = MutableStateFlow(NameInfoState(""))
    val nameInfoState: StateFlow<NameInfoState> = _nameInfoState.asStateFlow()

    init {
        getNameInfo()
    }

    private fun getNameInfo(){
        viewModelScope.launch {
            val nameInfo = nameRepository.getNameData()
            _nameInfoState.update {
                it.copy(string = nameInfo)
            }
        }
    }

}