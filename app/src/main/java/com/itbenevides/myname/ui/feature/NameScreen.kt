package com.itbenevides.myname.ui.feature

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.itbenevides.myname.ui.theme.NameTheme


@Composable
    fun NameRoute(
    viewModel: NameViewModel = viewModel(),
    ) {
        val nameInfoState by viewModel.nameInfoState.collectAsStateWithLifecycle()
        NameScreen(name = nameInfoState.string)
    }

    @Composable
    fun NameScreen(name: String){
        Surface {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxHeight()
            ){
                Text(
                    text = name,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }

    @Preview(showSystemUi = true, showBackground = false)
    @Composable
    fun NameScreenPreview(){
        NameTheme{
            NameScreen("Teste da silva")
        }
    }


