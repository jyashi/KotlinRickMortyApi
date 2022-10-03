package com.example.kotlinrickmortyapi.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.example.kotlinrickmortyapi.MainViewModel




@Composable
fun DetailsPage(
    index: Int,
    mainModel: MainViewModel,
    navController: NavController = rememberNavController(),
    descriptionFontSize: TextUnit = MaterialTheme.typography.subtitle1.fontSize,
    descriptionFontWeight: FontWeight = FontWeight.SemiBold,
) {
    val name = mainModel.data.value[index].name
    val species = mainModel.data.value[index].species
    val gender = mainModel.data.value[index].gender
    val planet = mainModel.data.value[index].origin["name"]
    val location = mainModel.data.value[index].location["name"]
    val created = mainModel.data.value[index].created
    val episodes = mainModel.data.value[index].episode.size
    Card(
        modifier = Modifier

            .padding(vertical = 25.dp, horizontal = 25.dp),
        elevation = 16.dp,
        shape = RoundedCornerShape(12.dp),
    ) {
        Column(verticalArrangement = Arrangement.SpaceEvenly, horizontalAlignment = Alignment.CenterHorizontally , modifier = Modifier
            .padding(25.dp)
            .fillMaxHeight()) {
//            verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                AsyncImage(
                    ImageRequest.Builder(LocalContext.current)
                        .data(mainModel.data.value[index].image).crossfade(true)
                        .transformations(CircleCropTransformation()).build(),
                    contentDescription = null,
                    modifier = Modifier.padding(15.dp)
                )
                Spacer(modifier = Modifier.padding(15.dp))

            }
            Spacer(modifier = Modifier.padding(25.dp))
            Text(
                text = "$name is a $species of $gender gender from the planet $planet and currently resides on $location.",
                fontSize = descriptionFontSize,
                fontWeight = descriptionFontWeight,

            )
            Spacer(modifier = Modifier.padding(25.dp))
            Text(
                text = "$name was created on $created and has appeared in $episodes episodes  .",
                fontSize = descriptionFontSize,
                fontWeight = descriptionFontWeight
            )
            Spacer(modifier = Modifier.padding(25.dp))
            Button(colors = ButtonDefaults.buttonColors(backgroundColor = Color.DarkGray)
                ,onClick = {
                    navController.popBackStack()
                }) {
                Text(text = "Click to return")

            }



        }
    }


}