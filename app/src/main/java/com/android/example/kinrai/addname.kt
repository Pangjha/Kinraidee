package com.android.example.kinrai


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.android.example.kinrai.databinding.FragmentAddnameBinding
import com.android.example.kinrai.databinding.FragmentTitleBinding
import kotlinx.android.synthetic.main.fragment_addname.*

/**
 * A simple [Fragment] subclass.
 */
class addname : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentAddnameBinding>(inflater,
            R.layout.fragment_addname,container,false)


        return binding.root
    }


}
