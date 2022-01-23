package com.example.spacedim

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.spacedim.databinding.FragmentGameBinding
import com.example.spacedim.databinding.FragmentJoinACrewBinding
import com.example.spacedim.network.User
import com.example.spacedim.UserAdapter
/*import com.example.spacedim.network.UserAdapter*/
import com.example.spacedim.viewModel.MainPageViewModel
import okhttp3.WebSocketListener


class JoinACrew : Fragment() {
    private val sharedViewModel: MainPageViewModel by activityViewModels()
    private val wsViewModel: WSViewModel by activityViewModels()

    lateinit var monRecycler: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentJoinACrewBinding>(inflater, R.layout.fragment_join_a_crew,container,false)
        /**/


        var listUsers = ArrayList<User>()
        wsViewModel.listener.eventWaitingForPlayers.observe(this, { retour ->
            listUsers = ArrayList<User>()
            retour.userList.forEach {
                listUsers.add(it)
            }
            monRecycler = binding.userRecyclerView
            monRecycler.layoutManager = LinearLayoutManager(context)
            monRecycler.adapter = UserAdapter(listUsers.toTypedArray()){
                Toast.makeText(context,"Vous avez sélectionné ${it.name}", Toast.LENGTH_SHORT).show()
            }
        })

        monRecycler = binding.userRecyclerView
        monRecycler.layoutManager = LinearLayoutManager(context)
        monRecycler.adapter = UserAdapter(listUsers.toTypedArray()){
            Toast.makeText(context,"Vous avez sélectionné ${it.name}", Toast.LENGTH_SHORT).show()
        }
/**/
        binding.joinAGameButton2.setOnClickListener{view : View ->
            wsViewModel.ready()
        /*view.findNavController().navigate(R.id.action_joinACrew_to_game)*/
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