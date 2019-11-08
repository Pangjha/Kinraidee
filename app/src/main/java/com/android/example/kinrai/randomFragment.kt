package com.android.example.kinrai


import android.content.Intent
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
import kotlinx.android.synthetic.main.fragment_random.*

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

        setHasOptionsMenu(true)
    binding.shareButton.setOnClickListener {
shareSuccess()
    }


        return binding.root
    }
    // Creating our Share Intent


//    private fun getShareIntent() : Intent {
//        val args = randomFragmentArgs.fromBundle(arguments!!)
//        val shareIntent = Intent(Intent.ACTION_SEND)
//        shareIntent.setType("text/plain")
//            .putExtra(Intent.EXTRA_TEXT, getString(R.string.share_success_text, args.numCorrect, args.numQuestions))
//        return shareIntent
//    }
private fun getShareIntent() : Intent {
    val shareIntent = Intent(Intent.ACTION_SEND)
    shareIntent.setType("text/plain")
        .putExtra(Intent.EXTRA_TEXT, getString(R.string.app_name))
    return shareIntent
}
    private fun shareSuccess() {
        startActivity(getShareIntent())
    }



}
