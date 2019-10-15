package com.android.example.kinrai


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.android.example.kinrai.databinding.FragmentListBinding
import com.android.example.kinrai.databinding.FragmentRandomBinding
import com.android.example.kinrai.databinding.FragmentTitleBinding

/**
 * A simple [Fragment] subclass.
 */
class randomFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentRandomBinding>(inflater,
            R.layout.fragment_random,container,false)




        return binding.root
    }


}
