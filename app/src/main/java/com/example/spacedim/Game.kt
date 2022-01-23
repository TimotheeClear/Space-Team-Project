package com.example.spacedim

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.gridlayout.widget.GridLayout
import androidx.navigation.findNavController
import com.example.spacedim.databinding.FragmentGameBinding
import com.example.spacedim.databinding.FragmentMainPageBinding
import com.example.spacedim.modele.Event
import com.example.spacedim.modele.UIElement
import com.example.spacedim.modele.UIType


class Game : Fragment() {
    private val wsViewModel: WSViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentGameBinding>(inflater,
            R.layout.fragment_game,container,false)

        /*binding.game1.setOnClickListener{view : View ->
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
        }*/
        setHasOptionsMenu(true)

        wsViewModel.listener.eventGameStarted.observe(viewLifecycleOwner, { gameStarted ->
            createButton(gameStarted.uiElementList , binding)
        })

        Log.i("game", "onCreateView called")
        return binding.root
    }

    private fun createButton(elementsList : List<UIElement>, binding: FragmentGameBinding) {
        elementsList.forEach {

            var grid: GridLayout = binding.gameGridLayout

            when (it.uiType) {
                UIType.BUTTON -> {
                    val viewButton = layoutInflater.inflate(R.layout.fragment_game1, grid, false)
                    val btn: Button = viewButton.findViewById(R.id.emergency_button)
                    btn.text = it.content
                    btn.setOnClickListener { view: View ->
                        wsViewModel.ws.send(PolymoObject.adapter.toJson(Event.PlayerAction(it)))
                        // Timber.i(PolymoObject.adapterSpace.toJson(Event.PlayerAction(it)))
                    }
                    grid.addView(viewButton)
                }

    UIType.SWITCH -> {
        val viewSwitch = layoutInflater.inflate(R.layout.fragment_game2, grid, false)
        val switch : Switch = viewSwitch.findViewById(R.id.switch_action)
        switch.text = it.content
        switch.setOnClickListener{ view : View ->
            wsViewModel.ws.send(PolymoObject.adapter.toJson(Event.PlayerAction(it)))
            // Timber.i(PolymoObject.adapterSpace.toJson(Event.PlayerAction(it)))
        }
        grid.addView(viewSwitch)
    }
}
}
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