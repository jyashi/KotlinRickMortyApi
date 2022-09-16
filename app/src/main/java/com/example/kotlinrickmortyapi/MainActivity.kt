package com.example.kotlinrickmortyapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding

import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.kotlinrickmortyapi.components.LazyListColumn
import com.example.kotlinrickmortyapi.components.myButton

import com.example.kotlinrickmortyapi.ui.theme.KotlinRickMortyApiTheme


class MainActivity : ComponentActivity() {
    val mainModel: MainViewModel by viewModels()
    var page: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        viewModel = viewModel()
//         viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        println("Printing ln")
        println(mainModel._RickMortyMutableData.value)

        setContent {

            var  myText = mainModel.RickMortyData.collectAsState().value
            KotlinRickMortyApiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
//                    Button(onClick = {
//                        ++page
//                        mainModel.getRickMortyCharacters(page = page.toString())
//
//
//
//
//                    },content= {
//
//                        if(myText.isNotEmpty()){
//                            Text(myText[0].name.toString())
//                        }
//                      else{
//                          Text("Waiting...")
//                        }
//
//
//
//                    } )

                    Column {
                                            LazyListColumn()
                    myButton(modifier = Modifier.padding(200.dp))

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