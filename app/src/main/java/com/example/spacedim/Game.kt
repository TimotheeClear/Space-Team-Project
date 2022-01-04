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
import com.example.spacedim.databinding.FragmentMainPageBinding


class Game : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentGameBinding>(inflater,
            R.layout.fragment_game,container,false)

        binding.game1.setOnClickListener{view : View ->
            view.findNavController().navigate(R.id.action_game_to_win)
        }
        binding.game2.setOnClickListener{view : View ->
            view.findNavController().navigate(R.id.action_game_to_lose)
        }
        binding.game3.setOnClickListener{view : View ->
            view.findNavController().navigate(R.id.action_game_to_lose)
        }
        binding.game4.setOnClickListener{view : View ->
            view.findNavController().navigate(R.id.action_game_to_lose)
        }
        setHasOptionsMenu(true)

        Log.i("game", "onCreateView called")
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("game", "onCreate called")
    }
    override fun onStart() {
        super.onStart()
        Log.i("game", "onStart called")
    }
    override fun onResume() {
        super.onResume()
        Log.i("game", "onResume called")
    }
    override fun onPause() {
        super.onPause()
        Log.i("game", "onPause called")
    }
    override fun onStop() {
        super.onStop()
        Log.i("game", "onStop called")
    }
    override fun onDestroyView() {
        super.onDestroyView()
        Log.i("game", "onDestroyView called")
    }
    override fun onDetach() {
        super.onDetach()
        Log.i("game", "onDetach called")
    }

}