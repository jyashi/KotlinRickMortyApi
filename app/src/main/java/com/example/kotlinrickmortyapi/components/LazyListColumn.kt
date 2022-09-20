package com.example.kotlinrickmortyapi.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.example.kotlinrickmortyapi.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


//class test {
//   val mainModel: MainViewModel by viewModel()
//}
val mainModel: MainViewModel = MainViewModel()


@Composable
fun LazyListColumn() {


    val scope = rememberCoroutineScope()

    var data = mainModel.RickMortyData.collectAsState().value
    var name: MutableState<String> = remember {
        mutableStateOf("Placeholder")
    }
    LaunchedEffect(true) {
        scope.launch(Dispatchers.IO) {
            if (data.isNotEmpty()) {
                name.value = data.first().name
                println("Name updated --> $name")
            }

        }
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(550.dp)
    ) {

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)


        )

        {


            items(mainModel.data.value.size) { index ->
                CharacterData(index = index)

            }


        }
    }


}


@Composable
fun CharacterData(index: Int) {

    Card(modifier = Modifier.fillMaxWidth().padding(vertical = 5.dp), elevation = 16.dp, shape = RoundedCornerShape(12.dp)) {
        Row() {


            Row() {
                AsyncImage(
                    ImageRequest.Builder(LocalContext.current)
                        .data(mainModel.data.value[index].image)
                        .crossfade(true)
                        .transformations(CircleCropTransformation())
                        .build(),
                    contentDescription = null, modifier = Modifier.padding(15.dp)
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



