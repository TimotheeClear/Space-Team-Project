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
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.android.spacedim.network.Api
import com.example.spacedim.databinding.FragmentMainPageBinding
import com.example.spacedim.network.User
import okhttp3.*
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException
import com.example.spacedim.viewModel.MainPageViewModel

class MainPage : Fragment() {
    private lateinit var viewModel: MainPageViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentMainPageBinding>(inflater, R.layout.fragment_main_page,container,false)

        //création viewModel de type MainPageViewModel
        viewModel = ViewModelProvider(this).get(MainPageViewModel::class.java)

        //obeserver sur la livedata response
        viewModel.response.observe(this, {
            it?.let{ user ->
                Log.i("truc", user.toString())
                /*view.findNavController().navigate(R.id.action_mainPage_to_getReady)*/
            }
        })

        //detect l'interaction avec le bouton
        binding.joinButton.setOnClickListener{view : View ->
           val pseudo : String = binding.codeName.getText().toString()
            //lancement de getFindUser qui modifie la liveData response
           viewModel.getFindUser(pseudo)
           /*val idPseudo = Api.retrofitService.findUser(pseudo).execute()
           idPseudo.body()?.let { user ->*/
           /*}*/
/*
*/
        }
        setHasOptionsMenu(true)

        return binding.root
    }

    private val client = OkHttpClient()

    fun identifyUser(pseudo : String) {
        Log.i("method", "identifyUser" )
    }

    fun connectUser(id : Int){
        Log.i("method", "connectUser" )

    }

/*    private fun getFindUser(pseudo : String) {
        Api.retrofitService.findUser(pseudo).enqueue(
            object: Callback<User> {
                override fun onFailure(call: Call<User>, t: Throwable) {
                    Log.i("Truc","Failure: " + t.message)
                }

                override fun onResponse(call: Call<User>, response: Response<User>) {
                    Log.i("Truc","Success: ${response.body()}")
                }
            })
    }*/
}