package com.android.example.kinrai


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.ListFragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import buu.s59160937.savemycards.ViewModel.RestsViewModelFactory
import com.android.example.kinrai.Database.RestsDatabase
import com.android.example.kinrai.databinding.FragmentListBinding

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


        binding.listResturant.layoutManager = LinearLayoutManager(activity)


        val application = requireNotNull(this.activity).application
        val dataSource = RestsDatabase.getInstance(application).restsDatabaseDao
        val viewModelFactory = RestsViewModelFactory(dataSource, application)

        val RestsViewModel =
            ViewModelProviders.of(
                this, viewModelFactory).get(RestsViewModel::class.java)
        //Clear data = uncomment
//        RestsViewModel.clearAllRest()

        val listAdapter = context?.let { listAdapter(it) }
        RestsViewModel.rests.observe(this, Observer { rests ->
            listAdapter?.data = rests as ArrayList<Resterant>
        })

        binding.toAddButton.setOnClickListener{view : View ->
            view.findNavController().navigate(R.id.action_listFragment_to_addname)

        }

        binding.setLifecycleOwner(this)




        binding.listResturant.adapter = listAdapter

        var name = arguments?.get("name").toString()


        if(!name.isNullOrEmpty() && !name.equals("null") && name.isNotEmpty() && name.isNotBlank()){
            var newRest = Resterant(0,name, "".toByteArray())
            Log.i("ListFragment", newRest.toString())
            RestsViewModel.addRest(newRest)
            Log.i("ListFragment", "Added Resterant")
        }

        binding.backtotitle.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_listFragment_to_titleFragment)
        }
        return binding.root
    }


}
