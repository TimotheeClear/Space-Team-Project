package com.example.spacedim.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.spacedim.network.Api
import com.example.spacedim.network.User
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPageViewModel : ViewModel(){

    private val _response = MutableLiveData<User?>()

    val response: LiveData<User?>
        get() = _response

    init {}

    fun getFindUser(pseudo : String) {
        //lancement code assyncronne car appel réseau
        viewModelScope.launch {
            //lancement de findUser
            // findUser est un methode Suspend car elle asyncronne, chaque action s'execute à la fin de la précédente
            try {
                val result = Api.retrofitService.findUser(pseudo)
                //on assigne une nouvelle valeur à response
                _response.value = result.body()
            } catch (e: Exception) {
                _response.value = null

            }
        }
    }
}