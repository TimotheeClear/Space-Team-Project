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
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
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
    private val sharedViewModel: MainPageViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentMainPageBinding>(inflater, R.layout.fragment_main_page,container,false)

        //obeserver sur la livedata user
        sharedViewModel.findUser.observe(this, {
            it?.let{ user ->
                Log.i("truc", user.toString())
                //appelle la fonction pour connecter un User au serveur
                sharedViewModel.connectUser(user.id)

            } ?: run {
                val input = binding.codeName.getText().toString()
                if ( input == ""){
                    Toast.makeText(context, "Veuillez choisir un pseudo", Toast.LENGTH_LONG).show()
                    Log.i("truc", "Veuillez choisir un pseudo")
                }
                else{
                    Toast.makeText(context, "Pseudo inconnue, veuillez vous enregistrer", Toast.LENGTH_LONG).show()
                    Log.i("truc", "Pseudo inconnue, veuillez vous enregistrer")
                }
            }
        })

        sharedViewModel.user.observe(this,{
            it?.let{user ->
                this.findNavController().navigate(R.id.action_mainPage_to_getReady)
            }
        })

        //detect l'interaction avec le bouton
        binding.joinButton.setOnClickListener{view : View ->
           val pseudo : String = binding.codeName.getText().toString()
            //lancement de getFindUser qui modifie la liveData user
            sharedViewModel.getFindUser(pseudo)
        }

        binding.buttonRegister.setOnClickListener{view : View ->
            view.findNavController().navigate(R.id.action_mainPage_to_signUp)
        }
        setHasOptionsMenu(true)

        return binding.root
    }
}