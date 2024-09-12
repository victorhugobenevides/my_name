package com.itbenevides.myname.ui.feature

import com.itbenevides.myname.data.repository.NameRepository
import com.itbenevides.myname.settings.Dispatchers
import com.itbenevides.myname.ui.feature.name.NameViewModel
import org.junit.Assert.assertEquals
import org.junit.Test


class NameViewModelTest: Dispatchers() {

    private lateinit var viewModel: NameViewModel
    @Test
    fun Get_Name_Success(){
        viewModel = NameViewModel(MockRepository())
        val name = viewModel.nameInfoState.value.string
        assertEquals("Pipoca docee", name)
    }
}

class MockRepository : NameRepository {
    override suspend fun getNameData(): String {
        return "Pipoca doce"
    }
}