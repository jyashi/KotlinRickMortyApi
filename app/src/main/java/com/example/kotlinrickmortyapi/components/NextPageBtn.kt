package com.example.kotlinrickmortyapi.components
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun changePageBtn() {
    Row(modifier = Modifier.padding(horizontal = 5.dp),
        verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
        if(mainModel.page.value != 1){
            IconButton(onClick = { mainModel.decrementPage()}) {
                Icon(Icons.Rounded.ArrowBack,null)
            }

        }
        else{
            IconButton(onClick = { /*TODO*/ }, enabled = false) {
                
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



