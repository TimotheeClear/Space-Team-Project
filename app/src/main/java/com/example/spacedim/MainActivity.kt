package com.example.spacedim

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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