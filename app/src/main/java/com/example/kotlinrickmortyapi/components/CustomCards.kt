package com.example.kotlinrickmortyapi.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import com.example.kotlinrickmortyapi.navigation.NavigationModel
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.example.kotlinrickmortyapi.MainViewModel


@ExperimentalMaterialApi
@Composable
fun ExpandableCard(
    mainModel: MainViewModel,
    index: Int,
    navController: NavController,
    titleFontSize: TextUnit = MaterialTheme.typography.h6.fontSize,
    titleFontWeight: FontWeight = FontWeight.Bold,
    descriptionFontSize: TextUnit = MaterialTheme.typography.subtitle1.fontSize,
    descriptionFontWeight: FontWeight = FontWeight.Normal,
    descriptionMaxLines: Int = 4,
//    shape: CornerBasedShape = CornerBasedShape.,
    padding: Dp = 12.dp
) {
    val data = mainModel.data.value[index]
    var expandedState by remember {
        mutableStateOf(false)
    }
    val rotationState by animateFloatAsState(
        targetValue = if (expandedState) 180f else 0f
    )

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = TweenSpec(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            ),
//        shape = shape,
        onClick = {
            expandedState = !expandedState
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(padding)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                AsyncImage(
                    ImageRequest.Builder(LocalContext.current)
                        .data(data.image).crossfade(true)
                        .transformations(CircleCropTransformation()).build(),
                    contentDescription = null,
                    modifier = Modifier.padding(15.dp)
                )
                Text(
                    modifier = Modifier.weight(6f),
                    text = data.name,
                    fontSize = titleFontSize,
                    fontWeight = titleFontWeight,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                IconButton(
                    modifier = Modifier
                        .alpha(ContentAlpha.medium)
                        .weight(1f)
                        .rotate(rotationState),
                    onClick = {
                        expandedState = !expandedState
                    },
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "Drop Down Arrow"
                    )
                }
            }
            Spacer(modifier = Modifier.padding(5.dp))
            if (expandedState) {
                Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {


                    Row(modifier = Modifier
                        .fillMaxSize()
                        ) {
                        Column() {
                            Text("Name : ")
                            Text("Species : ")
                            Text("Gender : ")
                            Text("Status : ")


                        }
                        Column() {
                            Text(
                                text = data.name,
                                fontSize = descriptionFontSize,
                                fontWeight = descriptionFontWeight,
                                maxLines = descriptionMaxLines,
                                overflow = TextOverflow.Ellipsis
                            )
                            Text(
                                text = data.species,
                                fontSize = descriptionFontSize,
                                fontWeight = descriptionFontWeight,
                                maxLines = descriptionMaxLines,
                                overflow = TextOverflow.Ellipsis
                            )
                            Text(
                                text = data.gender,
                                fontSize = descriptionFontSize,
                                fontWeight = descriptionFontWeight,
                                maxLines = descriptionMaxLines,
                                overflow = TextOverflow.Ellipsis
                            )
                            Text(
                                text = data.status,
                                fontSize = descriptionFontSize,
                                fontWeight = descriptionFontWeight,
                                maxLines = descriptionMaxLines,
                                overflow = TextOverflow.Ellipsis
                            )



                        }



                    }

                    Spacer(modifier = Modifier
                        .padding(20.dp)
                        .height(2.dp)
                        .fillMaxWidth()
                        .background(color = Color.White))
                    Button(colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.background),
                        onClick = {

                            navController.navigate(route = NavigationModel.DetailPage.passIndex(index)) }
                    ) {
                        Text(text = "Click to know more")
                    }
                }


            }
        }
    }
}