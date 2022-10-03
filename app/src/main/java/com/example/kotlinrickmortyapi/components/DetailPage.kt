package com.example.kotlinrickmortyapi.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NoLiveLiterals
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
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



//@NoLiveLiterals
@Composable
fun DetailsPage(
    index: Int,
    mainModel: MainViewModel,
    navController: NavController = rememberNavController(),
    descriptionFontSize: TextUnit = MaterialTheme.typography.subtitle1.fontSize,
    descriptionFontWeight: FontWeight = FontWeight.SemiBold,
    highlightWeight: FontWeight = FontWeight.W200
) {
    val name = mainModel.data.value[index].name
    val species = mainModel.data.value[index].species
    val gender = mainModel.data.value[index].gender
    val planet = mainModel.data.value[index].origin["name"]?:"unknown"
    val location = mainModel.data.value[index].location["name"]?:"unknown"
    val created = mainModel.data.value[index].created
    val episodes = mainModel.data.value[index].episode.size
    val style = SpanStyle(color = Color.Yellow, fontWeight = highlightWeight)
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

                buildAnnotatedString {

                    withStyle(style = style ){
                        append(name)
                    }
                    append(" is a ")

                    withStyle(style = style){

                        append(species)
                    }
                    append(" of ")
                    withStyle(style = style){
                        append(gender)
                    }
                    append(" gender from the planet ")
                    withStyle(style = style) {
                        append(planet)
                    }
                    append(" and currently resides on ")
                    withStyle(style = style){
                        append(location)
                    }
                    append(".")
                },
                fontSize = descriptionFontSize,
                fontWeight = descriptionFontWeight,

            )
            Spacer(modifier = Modifier.padding(25.dp))
            Text(
                buildAnnotatedString {
                    withStyle(style = style ){
                        append(name)
                    }
                    append(" was created on ")
                    withStyle(style = style ){
                        append(created)
                    }
                    append(" and has appeared in ")
                    withStyle(style = style ){
                        append(episodes.toString())
                    }
                   append( " episodes ")
                },

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