package com.example.kotlinrickmortyapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.findNavController
import com.example.kotlinrickmortyapi.components.LazyListColumn
import com.example.kotlinrickmortyapi.components.changePageBtn
import com.example.kotlinrickmortyapi.navigation.Navigation
import com.example.kotlinrickmortyapi.ui.theme.KotlinRickMortyApiTheme


class MainActivity : ComponentActivity() {
    val mainModel: MainViewModel by viewModels()
    var page: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println(mainModel._RickMortyMutableData.value)

        setContent {


            KotlinRickMortyApiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    Column(verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally) {
                        LazyListColumn()

                    }
                }

            }
        }
    }
}




@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    KotlinRickMortyApiTheme {
        Greeting("Android")
    }
}