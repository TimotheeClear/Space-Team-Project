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
import com.example.spacedim.databinding.FragmentLoseBinding
import com.example.spacedim.databinding.FragmentWinBinding


class lose : Fragment() {
    private val wsViewModel: WSViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentLoseBinding>(inflater,
            R.layout.fragment_lose,container,false)

        binding.button.setOnClickListener{view : View ->
            view.findNavController().navigate(R.id.action_lose_to_mainPage)
        }
        setHasOptionsMenu(true)
        var elScore : TextView = binding.loseFinalScore
        wsViewModel.listener.eventGameEnded.observe(viewLifecycleOwner,{gameEnded ->
            var scoreText : TextView =elScore.findViewById(R.id.loseFinalScore)
            scoreText.text = gameEnded.score.toString()
        })
        Log.i("Lose", "onCreateView called")
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("Lose", "onCreate called")
    }
    override fun onStart() {
        super.onStart()
        Log.i("Lose", "onStart called")
    }
    override fun onResume() {
        super.onResume()
        Log.i("Lose", "onResume called")
    }
    override fun onPause() {
        super.onPause()
        Log.i("Lose", "onPause called")
    }
    override fun onStop() {
        super.onStop()
        Log.i("Lose", "onStop called")
    }
    override fun onDestroyView() {
        super.onDestroyView()
        Log.i("Lose", "onDestroyView called")
    }
    override fun onDetach() {
        super.onDetach()
        Log.i("Lose", "onDetach called")
    }
}