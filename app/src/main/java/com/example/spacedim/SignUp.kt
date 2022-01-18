package com.example.spacedim

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.spacedim.databinding.FragmentSignUpBinding

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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentSignUpBinding>(inflater,
            R.layout.fragment_sign_up,container,false)

        binding.joinButton.setOnClickListener{view : View ->
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