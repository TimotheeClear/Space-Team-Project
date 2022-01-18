package com.example.spacedim

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.android.spacedim.network.ApiService
import com.example.spacedim.databinding.FragmentSignUpBinding
import com.example.spacedim.network.User
import com.example.spacedim.viewModel.MainPageViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SignUp.newInstance] factory method to
 * create an instance of this fragment.
 */
class SignUp : Fragment() {
    private lateinit var viewModel: MainPageViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentSignUpBinding>(inflater,
            R.layout.fragment_sign_up,container,false)
        viewModel = ViewModelProvider(this).get(MainPageViewModel::class.java)
        binding.joinButton.setOnClickListener{view : View ->
            val name_register : String = binding.codeName.getText().toString()
            val user_register = UserPost(name_register)
            viewModel.register_User(user_register)
            view.findNavController().navigate(R.id.action_signUp_to_mainPage)
        }
        setHasOptionsMenu(true)

        Log.i("SignUp", "onCreateView called")
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("SignUp", "onCreate called")
    }
    override fun onStart() {
        super.onStart()
        Log.i("SignUp", "onStart called")
    }
    override fun onResume() {
        super.onResume()
        Log.i("SignUp", "onResume called")
    }
    override fun onPause() {
        super.onPause()
        Log.i("SignUp", "onPause called")
    }
    override fun onStop() {
        super.onStop()
        Log.i("SignUp", "onStop called")
    }
    override fun onDestroyView() {
        super.onDestroyView()
        Log.i("SignUp", "onDestroyView called")
    }
    override fun onDetach() {
        super.onDetach()
        Log.i("SignUp", "onDetach called")
    }
}