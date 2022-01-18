package com.example.spacedim

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.WebSocket
import okhttp3.WebSocketListener
import okio.ByteString
class EchoWebSocketListener : WebSocketListener() {
    private val NORMAL_CLOSURE_STATUS: Int = 1000;

    override fun onOpen(webSocket: WebSocket, response: okhttp3.Response) {
        Log.i("WebSocket", "open")
    }

    override fun onMessage(webSocket: WebSocket, text: String) {
        super.onMessage(webSocket, "Receiving : " + text)
        Log.i("WebSocket", "Receiving : " + text)
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