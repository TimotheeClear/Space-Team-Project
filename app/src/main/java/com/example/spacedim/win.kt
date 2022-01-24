package com.example.spacedim

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.spacedim.databinding.FragmentJoinACrewBinding
import com.example.spacedim.databinding.FragmentWinBinding


class win : Fragment() {

    private val wsViewModel: WSViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentWinBinding>(inflater,
            R.layout.fragment_win,container,false)

        binding.button.setOnClickListener{view : View ->
            view.findNavController().navigate(R.id.action_win_to_mainPage)
        }
        setHasOptionsMenu(true)
        var elScore : TextView = binding.winFinalScore
        wsViewModel.listener.eventGameEnded.observe(viewLifecycleOwner,{gameEnded ->
            var scoreText : TextView =elScore.findViewById(R.id.winFinalScore)
            scoreText.text = gameEnded.score.toString()
        })
        Log.i("win", "onCreateView called")
        return binding.root


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("win", "onCreate called")
    }
    override fun onStart() {
        super.onStart()
        Log.i("win", "onStart called")
    }
    override fun onResume() {
        super.onResume()
        Log.i("win", "onResume called")
    }
    override fun onPause() {
        super.onPause()
        Log.i("win", "onPause called")
    }
    override fun onStop() {
        super.onStop()
        Log.i("win", "onStop called")
    }
    override fun onDestroyView() {
        super.onDestroyView()
        Log.i("win", "onDestroyView called")
    }
    override fun onDetach() {
        super.onDetach()
        Log.i("win", "onDetach called")
    }

}