package com.example.spacedim.viewModel

import android.util.Log
import android.widget.Toast
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

    private val _user = MutableLiveData<User?>()
    val user: LiveData<User?>
        get() = _user

    private val _userConected = MutableLiveData<User?>()
    val userConnected: LiveData<User?>
        get() = _userConected

    init {}

    fun getFindUser(pseudo : String) {
        //lancement code assyncronne car appel réseau
        viewModelScope.launch {
            //lancement de findUser
            // findUser est un methode Suspend car elle asyncronne, chaque action s'execute à la fin de la précédente
            try {
                val result = Api.retrofitService.findUser(pseudo)
                //on assigne une nouvelle valeur à user
                _user.value = result.body()
            } catch (e: Exception) {
                _user.value = null
            }
        }
    }

    fun connectUser(id : Int) {
        viewModelScope.launch {
            try {
                val result = Api.retrofitService.logUser(id)
                _userConected.value = result.body()
            } catch (e: Exception) {
                _userConected.value = null

            }
        }
    }
}