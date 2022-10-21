package com.example.kotlinrickmortyapi.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kotlinrickmortyapi.MainViewModel


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun LazyListColumn(mainModel: MainViewModel, navController: NavController = rememberNavController()) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()

    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()




        ) {
            LazyColumn(
                modifier = Modifier
                    .padding(12.dp)
            ) {
                items(mainModel.data.value.size) { index ->
                    ExpandableCard(index = index, navController = navController, mainModel = mainModel)
                }
                item { 
                    Spacer(modifier = Modifier.padding(45.dp))
                }

            }

            LoadingBar(showing = mainModel.isLoading.value, modifier = Modifier.align(Center))
            // Page change button
            Row(
                verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .align(BottomCenter)
                    .padding(vertical = 50.dp)
                    .background(
                        color = Color.DarkGray.copy(alpha = 0.5f),
                        shape = RoundedCornerShape(50.dp)
                    )) {
                if(mainModel.page.value != 1){
                    LaunchedEffect(key1 = true ){
                    }
                    IconButton(modifier= Modifier,onClick = {
                        mainModel.decrementPage()}) {
                        Icon(Icons.Rounded.ArrowBack,null)
                    }

                }

                else{
                    IconButton(modifier = Modifier, onClick = { /*TODO*/ }, enabled = false) {
                    }

                }
                Text(text = mainModel.page.value.toString())

                if (mainModel.page.value == 42){
                    IconButton(modifier = Modifier, onClick = { /*TODO*/ }, enabled = false) {
                    }
                }
                else {
                    IconButton( onClick = {
                        mainModel.incrementPage()
                    }) {

                        Icon(Icons.Rounded.ArrowForward,null)

                    }
                }


            }


        }

    }
}


@Composable
fun LoadingBar(showing: Boolean, modifier: Modifier) {
    if (showing) {
        CircularProgressIndicator(modifier = modifier)
    }
}





