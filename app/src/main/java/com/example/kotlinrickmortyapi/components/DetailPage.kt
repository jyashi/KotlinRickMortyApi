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
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.example.kotlinrickmortyapi.MainViewModel


@Composable
fun testPg(navController: NavController){
    Column {
        Text(text = "Dummy Text here that pops", modifier = Modifier.align(Alignment.End))
    }
}

@Composable
fun DetailsPage(
    index: Int,
    mainModel: MainViewModel,
    navController: NavController = rememberNavController()
) {
    val name = mainModel.data.value[index].name
    val species = mainModel.data.value[index].species
    val gender = mainModel.data.value[index].gender

    Card(
        modifier = Modifier

            .padding(vertical = 25.dp, horizontal = 25.dp),
        elevation = 16.dp,
        shape = RoundedCornerShape(12.dp),
    ) {
        Column(verticalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.padding(25.dp)) {
//            verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally

            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
                AsyncImage(
                    ImageRequest.Builder(LocalContext.current)
                        .data(mainModel.data.value[index].image).crossfade(true)
                        .transformations(CircleCropTransformation()).build(),
                    contentDescription = null,
                    modifier = Modifier.padding(15.dp)
                )
                Spacer(modifier = Modifier.padding(15.dp))
                Text(name)

            }
            Spacer(modifier = Modifier.padding(25.dp))
            Text(text = "$name is a $species of $gender gender")

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {


            }


        }
    }


}