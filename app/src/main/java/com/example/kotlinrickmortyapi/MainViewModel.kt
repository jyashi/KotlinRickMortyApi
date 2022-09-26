package com.example.kotlinrickmortyapi
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


class MainViewModel(private val repository: Repository = Repository(ApiClient().apiService)):
    ViewModel() {
    var isLoading: MutableState<Boolean> = mutableStateOf(false)
    var page: MutableState<Int> = mutableStateOf(1)
    var _data = mutableStateOf(listOf<RickMortyCharacter>())
    var data : State<List<RickMortyCharacter>> = _data

//private var _data = emptyList<RickMortyCharacter>().toMutableStateList()
//    val data: List<RickMortyCharacter>
//    get() = _data
//    var data : State<List<RickMortyCharacter>> = _data
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

 suspend fun myDelay(){
     isLoading.value = true
    delay(1000)
}

    private fun getRickMortyCharacters() {
        //TODO Get the repo
        isLoading.value = true
        val client = repository.getRickMortyCharacters(page = page.value.toString())
        client.enqueue(object : Callback<RickMortyCharactersList>{
            override fun onResponse(
                call: Call<RickMortyCharactersList>,
                response: Response<RickMortyCharactersList>
            ) {
                if(response.isSuccessful){
                    _RickMortyMutableData.value = response.body()?.result!!
                  _data.value = response.body()?.result!!
                    isLoading.value = false

                }
            }

            override fun onFailure(call: Call<RickMortyCharactersList>, t: Throwable) {
//                _data = onError as MutableList<RickMortyCharacter>
                isLoading.value = false
            }
        }


        )
    }
}