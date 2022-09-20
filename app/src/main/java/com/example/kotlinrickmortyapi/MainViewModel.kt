package com.example.kotlinrickmortyapi

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlinrickmortyapi.components.mainModel
import com.example.kotlinrickmortyapi.model.ApiClient
import com.example.kotlinrickmortyapi.model.RickMortyCharacter
import com.example.kotlinrickmortyapi.model.RickMortyCharactersList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainViewModel(private val repository: Repository = Repository(ApiClient().apiService)):
    ViewModel() {
    var page: MutableState<Int> = mutableStateOf(1)
    var _name = mutableStateOf("Name")
    var name : State<String> = _name
    var _data = mutableStateOf(placeHolderList())
    var data : State<List<RickMortyCharacter>> = _data
         var _RickMortyMutableData = MutableStateFlow<List<RickMortyCharacter>>(listOf())
        val RickMortyData: StateFlow<List<RickMortyCharacter>> get() = _RickMortyMutableData


        init {
            viewModelScope.launch { getRickMortyCharacters() }
        }

    fun incrementPage() {
        ++mainModel.page.value
        mainModel.getRickMortyCharacters()
    }

    fun decrementPage() {
        --mainModel.page.value
        mainModel.getRickMortyCharacters()
    }



    private fun getRickMortyCharacters() {
        //TODO Get the repo
        val client = repository.getRickMortyCharacters(page = page.value.toString())
        client.enqueue(object : Callback<RickMortyCharactersList>{
            override fun onResponse(
                call: Call<RickMortyCharactersList>,
                response: Response<RickMortyCharactersList>
            ) {
                if(response.isSuccessful){
                    _RickMortyMutableData.value = response.body()?.result!!
                    _data.value = response.body()?.result!!
                    println("New data --> ${_RickMortyMutableData.value.first().name}")
                   _name.value =  _RickMortyMutableData.value.first().name
                    println("_name.value --> ${_name.value}")
                    println("name.value --> ${name.value}")
                }
            }

            override fun onFailure(call: Call<RickMortyCharactersList>, t: Throwable) {
                TODO("Not yet implemented")
            }
        }


        )
    }
}