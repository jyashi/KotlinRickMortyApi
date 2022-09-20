package com.example.kotlinrickmortyapi.components
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

var page: MutableState<Int> =
    mutableStateOf(1)

@Composable
fun nextPageButton() {
    Row(modifier = Modifier.padding(horizontal = 5.dp), verticalAlignment = Alignment.CenterVertically) {
        Text(text = page.value.toString())
        IconButton( onClick = {
            incrementPage()
        }) {

            Icon(Icons.Filled.PlayArrow,null)

        }
    }


}

fun incrementPage() {
    ++page.value
    mainModel.getRickMortyCharacters(page = page.value.toString())
}