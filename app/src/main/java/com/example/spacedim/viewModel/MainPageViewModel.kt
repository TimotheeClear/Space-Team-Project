package com.example.spacedim.viewModel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.spacedim.network.Api
import com.example.spacedim.EchoWebSocketListener
import com.example.spacedim.network.User
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.WebSocket
import okhttp3.WebSocketListener
import okio.ByteString
import okio.ByteString.Companion.decodeHex
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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

    var client = OkHttpClient()
    var ws : WebSocket? = null

    fun start(roomName : String, userId : Int) {
        val request: Request = Request.Builder().url("ws://spacedim.async-agency.com:8081/ws/join/"+roomName+"/"+userId.toString()).build()
        val listener = EchoWebSocketListener()
        ws = client.newWebSocket(request, listener)
    }

    fun ready(){
        ws?.send("{\"type\":\"READY\", \"value\":true}")
    }
}