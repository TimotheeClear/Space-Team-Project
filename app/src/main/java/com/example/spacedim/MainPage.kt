package com.example.spacedim

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.databinding.DataBindingUtil
import com.example.spacedim.databinding.FragmentMainPageBinding

class MainPage : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentMainPageBinding>(inflater,
            R.layout.fragment_main_page,container,false)

       binding.joinButton.setOnClickListener { view: View ->
           view.findNavController().navigate(R.id.action_mainPage_to_getReady)
       }
        binding.buttonRegister.setOnClickListener{view : View ->
            view.findNavController().navigate(R.id.action_mainPage_to_getReady)
        }


        setHasOptionsMenu(true)

        return binding.root
    }

}