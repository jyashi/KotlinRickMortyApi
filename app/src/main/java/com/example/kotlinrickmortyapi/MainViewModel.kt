package com.example.kotlinrickmortyapi

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlinrickmortyapi.model.ApiClient
import com.example.kotlinrickmortyapi.model.RickMortyCharacter
import com.example.kotlinrickmortyapi.model.RickMortyCharactersList
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainViewModel(private val repository: Repository = Repository(ApiClient().apiService)) :
    ViewModel() {
    var isLoading: MutableState<Boolean> = mutableStateOf(false)
    var page: MutableState<Int> = mutableStateOf(1)
    private var _data = mutableStateOf(listOf<RickMortyCharacter>())
    var data: State<List<RickMortyCharacter>> = _data
    var _RickMortyMutableData = MutableStateFlow<List<RickMortyCharacter>>(listOf())

    init {
        viewModelScope.launch { getRickMortyCharacters() }
    }

    fun incrementPage() {
        ++page.value
        getRickMortyCharacters()
    }

    fun decrementPage() {
        --page.value
        getRickMortyCharacters()
    }

    suspend fun myDelay() {
        isLoading.value = true
        delay(1000)
    }

    private fun getRickMortyCharacters() {

        isLoading.value = true
        val client = repository.getRickMortyCharacters(page = page.value.toString())
        client.enqueue(object : Callback<RickMortyCharactersList> {
            override fun onResponse(
                call: Call<RickMortyCharactersList>,
                response: Response<RickMortyCharactersList>
            ) {
                if (response.isSuccessful) {
                    _RickMortyMutableData.value = response.body()?.result!!
                    _data.value = response.body()?.result!!
                    Log.d("View model", "Data value was --> ${_data.value}")
                    isLoading.value = false

                }
            }

            override fun onFailure(call: Call<RickMortyCharactersList>, t: Throwable) {
                isLoading.value = false
            }
        }


        )
    }
}