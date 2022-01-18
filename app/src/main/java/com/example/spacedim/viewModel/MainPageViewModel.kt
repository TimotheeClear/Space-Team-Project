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
    val userConnected: LiveData<User?>
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
                _findUser.value = result.body()

            } catch (e: Exception) {
                _findUser.value = null
            }
        }
    }

    fun connectUser(id: Int) {
        viewModelScope.launch {
            try {
                val result = Api.retrofitService.logUser(id)
                Log.i("truc", "Réussite connection")
                _user.value = result.body()
            } catch (e: Exception) {
                Log.i("truc", "Echec connection")
                _user.value = null
            }
        }
    }


    var client = OkHttpClient()

    private class EchoWebSocketListener : WebSocketListener() {
        private val NORMAL_CLOSURE_STATUS: Int = 1000;

        override fun onOpen(webSocket: WebSocket, response: okhttp3.Response) {
            Log.i("truc", "open")
        }

        override fun onMessage(webSocket: WebSocket, text: String) {
            super.onMessage(webSocket, "Receiving : " + text)
            Log.i("truc", "Receiving : " + text)
        }

        override fun onMessage(webSocket: WebSocket, bytes: ByteString) {
            super.onMessage(webSocket, "Receiving bytes : " + bytes)
            Log.i("truc", "Receiving bytes : " + bytes)
        }

        override fun onFailure(webSocket: WebSocket, t: Throwable, response: okhttp3.Response?) {
            super.onFailure(webSocket, t, response)
            Log.i("truc","Error")
        }
    }

    var ws : WebSocket? = null

    fun start() {
        val request: Request = Request.Builder().url("ws://spacedim.async-agency.com:8081/ws").build()
        val listener = EchoWebSocketListener()
        ws = client.newWebSocket(request, listener)
    }
}