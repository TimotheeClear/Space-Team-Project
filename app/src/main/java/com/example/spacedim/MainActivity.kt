package com.example.spacedim

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.squareup.moshi.JsonClass
import com.squareup.moshi.Moshi
import okhttp3.*
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("MainPage","onCreate called")
        run()
    }

    private val client = OkHttpClient()
/*    private val moshi = Moshi.Builder().build()
    private val gistJsonAdapter = moshi.adapter(Gist::class.java)*/

    fun run() {
        val request = Request.Builder()
            .url("http://spacedim.async-agency.com:8081/api/users")
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {
                response.use {
                    if (!response.isSuccessful) throw IOException("Unexpected code $response")
                    val oui = response.body!!.string()
                    try {
                        val jsonObjects = JSONObject(oui)
                        Log.i("JSON_ALL", jsonObjects.toString() )

                    } catch (err: JSONException) {
                        Log.d("Error", err.toString())
                    }
                }
            }
        })
    }

/*    @JsonClass(generateAdapter = true)
    data class Gist(var files: Map<String, GistFile>?)

    @JsonClass(generateAdapter = true)
    data class GistFile(var content: String?)*/
        
    override fun onStart() {
        super.onStart()
        Log.i("MainPage", "onStart called")
    }
    override fun onResume() {
        super.onResume()
        Log.i("MainPage", "onResume called")
    }
    override fun onPause() {
        super.onPause()
        Log.i("MainPage", "onPause called")
    }
    override fun onStop() {
        super.onStop()
        Log.i("MainPage", "onStop called")
    }
}