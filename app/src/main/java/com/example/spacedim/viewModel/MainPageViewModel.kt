package com.example.spacedim.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.spacedim.network.Api

import com.example.spacedim.UserPost

import com.example.spacedim.EchoWebSocketListener

import com.example.spacedim.network.User
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.WebSocket

class MainPageViewModel : ViewModel() {

    private val _findUser = MutableLiveData<User?>()
    val findUser: LiveData<User?>
        get() = _findUser

    private val _user = MutableLiveData<User?>()
    val user: LiveData<User?>
        get() = _user

    init {
    }

    fun getFindUser(pseudo: String) {
        //lancement code assyncronne car appel réseau
        viewModelScope.launch {
            //lancement de findUser
            // findUser est un methode Suspend car elle asyncronne, chaque action s'execute à la fin de la précédente
            try {
                val result = Api.retrofitService.findUser(pseudo)
                _findUser.postValue(result.body())

            } catch (e: Exception) {
                _findUser.postValue(null)
            }
        }
    }

    fun connectUser(id: Int) {
        viewModelScope.launch {
            try {
                val result = Api.retrofitService.logUser(id)
                Log.i("truc", "Réussite connection")
                _user.postValue(result.body())
            } catch (e: Exception) {
                Log.i("truc", "Echec connection")
                _user.postValue(null)
            }
        }
    }

    fun register_User(userPost: UserPost) {
        viewModelScope.launch {
            try {
                val result = Api.retrofitService.registerUser( userPost )
                Log.i("UserPost", "Réussite enregistrement")
            } catch (e: Exception) {
                Log.i("UserPost", e.toString())
                Log.i("UserPost","Erreur de connexion")
                Log.i("UserPost", userPost.toString())
            }
        }
    }
}

