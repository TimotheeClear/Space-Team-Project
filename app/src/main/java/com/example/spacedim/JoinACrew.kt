package com.example.spacedim

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.spacedim.databinding.FragmentGameBinding
import com.example.spacedim.databinding.FragmentJoinACrewBinding


class JoinACrew : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentJoinACrewBinding>(inflater,
            R.layout.fragment_join_a_crew,container,false)

        binding.joinAGameButton2.setOnClickListener{view : View ->
            view.findNavController().navigate(R.id.action_joinACrew_to_game)
        }
        setHasOptionsMenu(true)

        Log.i("JoinACrew", "onCreateView called")
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("JoinACrew", "onCreate called")
    }
    override fun onStart() {
        super.onStart()
        Log.i("JoinACrew", "onStart called")
    }
    override fun onResume() {
        super.onResume()
        Log.i("JoinACrew", "onResume called")
    }
    override fun onPause() {
        super.onPause()
        Log.i("JoinACrew", "onPause called")
    }
    override fun onStop() {
        super.onStop()
        Log.i("JoinACrew", "onStop called")
    }
    override fun onDestroyView() {
        super.onDestroyView()
        Log.i("JoinACrew", "onDestroyView called")
    }
    override fun onDetach() {
        super.onDetach()
        Log.i("JoinACrew", "onDetach called")
    }
}