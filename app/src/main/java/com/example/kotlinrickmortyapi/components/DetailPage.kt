package com.example.kotlinrickmortyapi.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.example.kotlinrickmortyapi.MainViewModel

@Composable
fun DetailPage(index: Int, mainModel: MainViewModel = viewModel(),navController: NavController) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp),
        elevation = 16.dp,
        shape = RoundedCornerShape(12.dp),
    ) {
        Row() {


            Row() {
                AsyncImage(
                    ImageRequest.Builder(LocalContext.current)
                        .data(mainModel.data.value[index].image).crossfade(true)
                        .transformations(CircleCropTransformation()).build(),
                    contentDescription = null,
                    modifier = Modifier.padding(15.dp)
                )
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Spacer(modifier = Modifier.padding(15.dp))
                    Text(mainModel.data.value[index].name)
                    Text(mainModel.data.value[index].species)
                    Text(mainModel.data.value[index].gender)
                }
            }


        }
    }


}