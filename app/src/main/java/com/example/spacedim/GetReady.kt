package com.example.spacedim

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.spacedim.databinding.FragmentGetReadyBinding


class GetReady : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentGetReadyBinding>(inflater,
            R.layout.fragment_get_ready,container,false)

        binding.joinAGameButton.setOnClickListener{view : View ->
            view.findNavController().navigate(R.id.action_getReady_to_joinACrew)
        }
        setHasOptionsMenu(true)

        Log.i("GetReady", "onCreateView called")
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("GetReady", "onCreate called")
    }
    override fun onStart() {
        super.onStart()
        Log.i("GetReady", "onStart called")
    }
    override fun onResume() {
        super.onResume()
        Log.i("GetReady", "onResume called")
    }
    override fun onPause() {
        super.onPause()
        Log.i("GetReady", "onPause called")
    }
    override fun onStop() {
        super.onStop()
        Log.i("GetReady", "onStop called")
    }
    override fun onDestroyView() {
        super.onDestroyView()
        Log.i("GetReady", "onDestroyView called")
    }
    override fun onDetach() {
        super.onDetach()
        Log.i("GetReady", "onDetach called")
    }

}