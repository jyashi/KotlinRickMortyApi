package com.example.kotlinrickmortyapi

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlinrickmortyapi.model.ApiClient
import com.example.kotlinrickmortyapi.model.RickMortyCharactersList
import com.example.kotlinrickmortyapi.model.RickMortyCharacter
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(private val repository: Repository = Repository(ApiClient().apiService)):
    ViewModel() {
         var _RickMortyMutableData = MutableStateFlow<List<RickMortyCharacter>>(listOf())
        val RickMortyData: StateFlow<List<RickMortyCharacter>> get() = _RickMortyMutableData


        init {
            viewModelScope.launch { getRickMortyCharacters(page = "1") }
        }




     fun getRickMortyCharacters(page:String) {
        //TODO Get the repo
        val client = repository.getRickMortyCharacters(page = page)
        client.enqueue(object : Callback<RickMortyCharactersList>{
            override fun onResponse(
                call: Call<RickMortyCharactersList>,
                response: Response<RickMortyCharactersList>
            ) {
                if(response.isSuccessful){
                    _RickMortyMutableData.value = response.body()?.result!!
                    println("New data --> ${_RickMortyMutableData.value.first().name}")
                }
            }

            override fun onFailure(call: Call<RickMortyCharactersList>, t: Throwable) {
                TODO("Not yet implemented")
            }
        }


        )
    }
}