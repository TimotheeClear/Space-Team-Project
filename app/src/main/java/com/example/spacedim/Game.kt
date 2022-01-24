package com.example.spacedim

import android.animation.ObjectAnimator
import android.os.Bundle
import android.text.Layout
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
import androidx.navigation.fragment.findNavController
import com.example.spacedim.databinding.FragmentGameBinding
import com.example.spacedim.databinding.FragmentMainPageBinding
import com.example.spacedim.modele.Event
import com.example.spacedim.modele.UIElement
import com.example.spacedim.modele.UIType
import java.util.*


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
            var elLayout : TextView = binding.mission
            var elProgressBar : ProgressBar = binding.progressBar
        wsViewModel.listener.eventNextAction.observe(viewLifecycleOwner,{nextAction ->
            var imageText : TextView=elLayout.findViewById(R.id.mission)
            imageText.text = nextAction.action.sentence.toString()
            var pBar : ProgressBar =elProgressBar.findViewById(R.id.progressBar)
            pBar.progress = 0
            ObjectAnimator.ofInt(elProgressBar,"progress",100).setDuration(nextAction.action.time).start()
        })


        wsViewModel.listener.eventGameEnded.observe(viewLifecycleOwner,{gameEnded ->
            if (gameEnded.win == false)
                view?.findNavController()?.navigate(R.id.action_game_to_lose)
            if (gameEnded.win == true)
                view?.findNavController()?.navigate(R.id.action_game_to_win)

        })

        wsViewModel.listener.eventNextLevel.observe(viewLifecycleOwner, { nextLevel ->
            createButton(nextLevel.uiElementList , binding)
        })

        Log.i("game", "onCreateView called")
        return binding.root
    }

    private fun createButton(elementsList : List<UIElement>, binding: FragmentGameBinding) {
        var grid: GridLayout = binding.gameGridLayout
        grid.removeAllViews()
        elementsList.forEach {
            when (it.uiType) {
                UIType.BUTTON -> {
                    /*val viewButton = layoutInflater.inflate(R.layout.fragment_game1, grid, false)
                    val btn: Button = viewButton.findViewById(R.id.emergency_button)
                    btn.text = it.content

                    btn.setOnClickListener { view: View ->
                        wsViewModel.ws.send(PolymoObject.adapter.toJson(Event.PlayerAction(it)))
                        Log.i("gameTest", it.toString())
                        // Timber.i(PolymoObject.adapterSpace.toJson(Event.PlayerAction(it)))
                    }
                    grid.addView(viewButton)*/

                    Log.i("gameTest", it.toString())

                    val viewButton = layoutInflater.inflate(R.layout.fragment_game3, grid, false)
                    val image: ImageView = viewButton.findViewById(R.id.button_image)
                    val text: TextView = viewButton.findViewById(R.id.button_text)
                    //image. = "@drawable/emergency_button"
                    text.text = it.content

                    if(it.id == 4){
                        image.setImageResource(R.drawable.doc)
                    }
                    if(it.id == 2){
                        image.setImageResource(R.drawable.bombe)
                    }

                    image.setOnClickListener { view: View ->
                        wsViewModel.ws.send(PolymoObject.adapter.toJson(Event.PlayerAction(it)))
                        //Log.i("gameTest", it.toString())
                    }
                    grid.addView(viewButton)
                }

                UIType.SWITCH -> {
                    Log.i("gameTest", it.toString())
                    val viewSwitch = layoutInflater.inflate(R.layout.fragment_game2, grid, false)
                    val switch : Switch = viewSwitch.findViewById(R.id.switch_action)
                    switch.text = it.content
                    switch.setOnClickListener{ view : View ->
                        wsViewModel.ws.send(PolymoObject.adapter.toJson(Event.PlayerAction(it)))
                        //Log.i("gameTest", it.toString())
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