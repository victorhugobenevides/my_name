package com.itbenevides.myname.ui.feature.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.itbenevides.myname.R
import com.itbenevides.myname.data.model.Profile
import com.itbenevides.myname.ui.theme.ProfileTheme

@Composable
    fun ProfileRoute(
        viewModel: ProfileViewModel = viewModel(),
    ) {
        val state by viewModel.profileInfoState.collectAsStateWithLifecycle()

        when(state.result){
            StatusResult.Error -> {
                TODO("Estudar tratamento de erro")
            }
            StatusResult.Loading -> {
                LoadingScreen()
            }
            StatusResult.Success -> {
                ProfileScreen(profile = state.profile)
            }
        }
    }

    @Composable
    fun ProfileScreen(profile: Profile){
        Surface {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.padding(42.dp)
            ){
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(42.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(R.drawable.ic_launcher_background),
                        alignment = Alignment.Center,
                        contentDescription = "avatar",
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier
                            .size(120.dp)
                            .clip(CircleShape)
                            .border(2.dp, Color.Gray, CircleShape)
                    )
                    Text(
                        text = profile.name,
                        textAlign = TextAlign.Left,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp),
                        fontSize = 16.sp
                    )
                    Text(
                        text = profile.yearOfBirth.toString(),
                        textAlign = TextAlign.Right,
                        modifier = Modifier.fillMaxWidth(),
                        fontSize = 12.sp,
                    )
                }

            }
        }
    }

@Composable
fun LoadingScreen() {

    Surface {

            Column(
                modifier = Modifier
                    .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,

            ) {
                CircularProgressIndicator(
                    modifier = Modifier.width(64.dp),
                    color = MaterialTheme.colorScheme.secondary,
                    trackColor = MaterialTheme.colorScheme.surfaceVariant,
                )
            }
        }



}

    @Preview(showSystemUi = true, showBackground = false)
    @Composable
    fun ProfileScreenPreview(){
        ProfileTheme{
            ProfileScreen(
                Profile(
                name = "Victor Hugo Benevides Sobrinho",
                yearOfBirth = 1989)
            )
        }
    }


