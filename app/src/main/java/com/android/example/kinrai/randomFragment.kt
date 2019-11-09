package com.android.example.kinrai


import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import buu.s59160937.savemycards.ViewModel.RestsViewModelFactory
import com.android.example.kinrai.Database.RestsDatabase
import com.android.example.kinrai.databinding.FragmentListBinding
import com.android.example.kinrai.databinding.FragmentRandomBinding
import com.android.example.kinrai.databinding.FragmentTitleBinding
import kotlinx.android.synthetic.main.fragment_random.*
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.log

/**
 * A simple [Fragment] subclass.
 */
class randomFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val application = requireNotNull(this.activity).application
        val dataSource = RestsDatabase.getInstance(application).restsDatabaseDao
        val viewModelFactory = RestsViewModelFactory(dataSource, application)

        val RestsViewModel =
            ViewModelProviders.of(
                this, viewModelFactory
            ).get(RestsViewModel::class.java)


        val binding = DataBindingUtil.inflate<FragmentRandomBinding>(
            inflater,
            R.layout.fragment_random, container, false
        )

        setHasOptionsMenu(true)
        binding.shareButton.setOnClickListener {
            shareSuccess()

        }
        binding.randomButton.setOnClickListener {
            var resterant : Array<String> = RestsViewModel.arr

            //    var sizeRes = resterant.size
            var random = (0..resterant.size).random()
            Log.i("random", random.toString() + "test test")
            binding.textRandom.text = resterant[random]


        }

        return binding.root
    }
    // Creating our Share Intent

    private fun getShareIntent(): Intent {
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain")
            .putExtra(Intent.EXTRA_TEXT, getString(R.string.app_name))
        return shareIntent
    }

    private fun shareSuccess() {
        startActivity(getShareIntent())
    }


}
