package com.example.kotlinrickmortyapi.components
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import com.example.kotlinrickmortyapi.MainViewModel
import com.example.kotlinrickmortyapi.model.RickMortyCharacter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

//class test {
//   val mainModel: MainViewModel by viewModel()
//}
val mainModel: MainViewModel = MainViewModel()
var page:Int = 1
@Composable
 fun LazyListColumn() {

//    val mainModel: MainViewModel by viewModels()
//    var  myText = mainModel.RickMortyData.collectAsState().value
    val scope = rememberCoroutineScope()
//    var data = remeber { mutableStateOf(List<RickMortyCharacter>())}
     var data = mainModel.RickMortyData.collectAsState().value
    var name:MutableState<String> = remember {
        mutableStateOf("Placeholder")
    }
    LaunchedEffect(true){
 scope.launch (Dispatchers.IO){
     if(data.isNotEmpty()){
         name.value = data.first().name
         println("Name updated --> $name")
     }

 }
    }
    LazyColumn(modifier = Modifier.fillMaxWidth())
    {
        item {
            Column {
                Text("")
                Text(name.value)
                Text("There")
            }
        }




    }



}
fun incrementPage(){
    ++page
}
@Composable
fun myButton(modifier: Modifier) {
Surface{
    Button(onClick = { incrementPage()
        mainModel.getRickMortyCharacters(page.toString())}) {

        Text(text = mainModel.RickMortyData.collectAsState().value.toString())

    }
}

}