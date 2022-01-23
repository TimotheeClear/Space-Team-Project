package com.example.spacedim

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.spacedim.modele.Event
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.WebSocket
import okhttp3.WebSocketListener
import okio.ByteString

class WSViewModel : ViewModel() {
    var client = OkHttpClient()
    lateinit var ws : WebSocket
    lateinit var listener: EchoWebSocketListener;

    private val _roomName = MutableLiveData<String>()
    val roomName: LiveData<String>
        get() = _roomName

    fun start(roomName : String, userId : Int) {
        val request: Request = Request.Builder().url("ws://spacedim.async-agency.com:8081/ws/join/"+roomName+"/"+userId.toString()).build()
        listener = EchoWebSocketListener()
        ws = client.newWebSocket(request, listener)
        _roomName.postValue(roomName)
    }
}


class EchoWebSocketListener() : WebSocketListener() {

    private val _state = MutableLiveData<Boolean>()
    val state: LiveData<Boolean>
        get() = _state

    private val _eventGoToPlay = MutableLiveData<Boolean>()
    val eventGoToPlay: LiveData<Boolean>
        get() = _eventGoToPlay

    private val _eventGameStarted = MutableLiveData<Event.GameStarted>()
    val eventGameStarted: LiveData<Event.GameStarted>
        get() = _eventGameStarted

    private val _eventNextAction = MutableLiveData<Event.NextAction>()
    val eventNextAction: LiveData<Event.NextAction>
        get() = _eventNextAction

    private val _eventGameEnded = MutableLiveData<Event.GameOver>()
    val eventGameEnded: LiveData<Event.GameOver>
        get() = _eventGameEnded

    private val _eventNextLevel = MutableLiveData<Event.NextLevel>()
    val eventNextLevel: LiveData<Event.NextLevel>
        get() = _eventNextLevel

    private val _eventWaitingForPlayers = MutableLiveData<Event.WaitingForPlayer>()
    val eventWaitingForPlayers: LiveData<Event.WaitingForPlayer>
        get() = _eventWaitingForPlayers

    private val NORMAL_CLOSURE_STATUS: Int = 1000;

    override fun onOpen(webSocket: WebSocket, response: okhttp3.Response) {
        Log.i("WebSocket", "open")
        _state.postValue(true);
    }

    override fun onMessage(webSocket: WebSocket, text: String) {
        super.onMessage(webSocket, "Receiving : " + text)
        Log.i("WebSocket", "Receiving : " + text)
        try {
            val response = PolymoObject.adapter.fromJson(text)


            response?.let {
                if (response is Event.GameStarted) {
                    _eventGoToPlay.postValue(true)
                }
                if (response is Event.GameStarted) {
                    _eventGameStarted.postValue(response)
                }
                if (response is Event.NextAction) {
                    _eventNextAction.postValue(response)
                }
                if (response is Event.GameOver) {
                    _eventGameEnded.postValue(response)
                }
                if (response is Event.NextLevel) {
                    _eventNextLevel.postValue(response)
                }
                if(response is Event.WaitingForPlayer) {
                    _eventWaitingForPlayers.postValue(response)
                }
            }
        } catch (exception: Exception) {
            Log.i("WebSocket", "error websocket")
        }
    }

    override fun onMessage(webSocket: WebSocket, bytes: ByteString) {
        super.onMessage(webSocket, "Receiving bytes : " + bytes)
        Log.i("WebSocket", "Receiving bytes : " + bytes)
    }

    override fun onFailure(webSocket: WebSocket, t: Throwable, response: okhttp3.Response?) {
        super.onFailure(webSocket, t, response)
        Log.i("WebSocket","Error")
    }
}