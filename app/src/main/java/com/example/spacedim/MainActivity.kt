package com.example.spacedim

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.spacedim.databinding.ActivityMainBinding
import com.squareup.moshi.JsonClass
import com.squareup.moshi.Moshi
import okhttp3.*
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        Log.i("MainPage","onCreate called")
    }

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