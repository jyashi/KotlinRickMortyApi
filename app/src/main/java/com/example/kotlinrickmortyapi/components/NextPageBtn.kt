package com.example.kotlinrickmortyapi.components
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.kotlinrickmortyapi.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun onClickDecriment(){
    val scope = rememberCoroutineScope()
    LaunchedEffect(true){
        scope.launch(Dispatchers.IO) {
            delay(1000)
        }
    }
}


@Composable
 fun changePageBtn(modifier: Modifier,mainModel: MainViewModel = viewModel()) {
    Row(
        verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center,
        modifier = Modifier) {
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
        IconButton( onClick = {
            mainModel.incrementPage()
        }) {

            Icon(Icons.Rounded.ArrowForward,null)

        }

    }


}



