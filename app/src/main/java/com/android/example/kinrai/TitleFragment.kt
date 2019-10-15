package com.android.example.kinrai


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.android.example.kinrai.databinding.FragmentTitleBinding

/**
 * A simple [Fragment] subclass.
 */
class TitleFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentTitleBinding>(inflater,
            R.layout.fragment_title,container,false)

        binding.torandombutton.setOnClickListener{view : View ->
            view.findNavController().navigate(R.id.action_titleFragment_to_randomFragment)}

        binding.toListButton.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_titleFragment_to_listFragment)
        }
        return binding.root
    }


}
