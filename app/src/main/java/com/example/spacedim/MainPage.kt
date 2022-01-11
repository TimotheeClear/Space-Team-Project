package com.example.spacedim

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.databinding.DataBindingUtil
import com.example.spacedim.databinding.FragmentMainPageBinding
import okhttp3.*
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class MainPage : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentMainPageBinding>(inflater, R.layout.fragment_main_page,container,false)

       binding.joinButton.setOnClickListener{view : View ->
           identifyUser()

           view.findNavController().navigate(R.id.action_mainPage_to_getReady)
       }
        setHasOptionsMenu(true)

        return binding.root
    }

    private val client = OkHttpClient()

    fun getUsers() {
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

    fun getPseudo() {}

    fun identifyUser() {}


}