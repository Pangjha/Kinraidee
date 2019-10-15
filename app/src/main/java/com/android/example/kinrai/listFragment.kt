package com.android.example.kinrai


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.databinding.DataBindingUtil
import com.android.example.kinrai.databinding.FragmentListBinding
import com.android.example.kinrai.databinding.FragmentRandomBinding

/**
 * A simple [Fragment] subclass.
 */
class listFragment : Fragment() {
    var arrayTesttt = arrayOf("Melbourne", "Vienna",
        "Vancouver", "Toronto", "Calgary", "Adelaide", "Perth",
        "Auckland", "Helsinki", "Hamburg", "Munich", "New York",
        "Sydney", "Paris", "Cape Town", "Barcelona", "London", "Bangkok")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentListBinding>(inflater,
            R.layout.fragment_list,container,false)

      /*  val adapter = ArrayAdapter(this,R.layout.fragment_list,array)
        val listView: ListView = find
        listView.setAdapter(adapter)
*/

        return binding.root
    }


}
