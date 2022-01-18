package com.example.spacedim

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.spacedim.databinding.FragmentGetReadyBinding
import com.example.spacedim.viewModel.MainPageViewModel


class GetReady : Fragment() {
    private lateinit var viewModel: MainPageViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentGetReadyBinding>(inflater,
            R.layout.fragment_get_ready,container,false)

        viewModel = ViewModelProvider(this).get(MainPageViewModel::class.java)

        binding.joinAGameButton.setOnClickListener{view : View ->

            val roomName : String = binding.inputTextRoomName.getText().toString()
            if (roomName != "") {
                viewModel.user.value?.let {
                    viewModel.start(roomName, it.id)
                    view.findNavController().navigate(R.id.action_getReady_to_joinACrew)
                }
            } else {
                Toast.makeText(context, "Veuillez choisir un nom de room", Toast.LENGTH_LONG).show()
            }
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