package com.android.example.kinrai


import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.android.example.kinrai.databinding.FragmentAddnameBinding
import java.io.ByteArrayOutputStream
import android.graphics.drawable.BitmapDrawable
import androidx.core.graphics.drawable.toBitmap
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import buu.s59160937.savemycards.ViewModel.RestsViewModelFactory
import com.android.example.kinrai.Database.RestsDatabase


/**
 * A simple [Fragment] subclass.
 */
class addname() : Fragment() {
    lateinit var img: Bitmap


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //callDB
        val application = requireNotNull(this.activity).application
        val dataSource = RestsDatabase.getInstance(application).restsDatabaseDao
        val viewModelFactory = RestsViewModelFactory(dataSource, application)

        val RestsViewModel =
            ViewModelProviders.of(
                this, viewModelFactory).get(RestsViewModel::class.java)
///////
        val binding = DataBindingUtil.inflate<FragmentAddnameBinding>(inflater,
            R.layout.fragment_addname,container,false)


        binding.button2.setOnClickListener {

            if (::img.isInitialized){
                RestsViewModel.addRest(Resterant(0,binding.addStoreText.text.toString(), encodeImg(img)))
                this.view?.findNavController()?.navigate(R.id.action_addname_to_listFragment)
            }else{
            val action = addnameDirections.actionAddnameToListFragment()
            action.name = binding.addStoreText.text.toString()
            findNavController().navigate(action)
            }


        }
        binding.addImg.setOnClickListener{
            pickImageFromGallery()
        }
        return binding.root
    }


    fun encodeImg(img: Bitmap): ByteArray{
        val outputStream = ByteArrayOutputStream()
        img.compress(Bitmap.CompressFormat.JPEG, 0, outputStream)
        return outputStream.toByteArray()
    }

    private fun pickImageFromGallery() {
        //Intent to pick image
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_PICK_CODE)
    }

    companion object {
        //image pick code
        private val IMAGE_PICK_CODE = 1000;
        //Permission code
        private val PERMISSION_CODE = 1001;
    }

    //handle requested permission result
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when(requestCode){
            PERMISSION_CODE -> {
                if (grantResults.size >0 && grantResults[0] ==
                    PackageManager.PERMISSION_GRANTED){
                    //permission from popup granted
                    pickImageFromGallery()
                }
                else{
                    //permission from popup denied

                }
            }
        }
    }

    //handle result of picked image
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK && requestCode == IMAGE_PICK_CODE){
            var testImg : ImageView = ImageView(this.context)
            testImg.setImageURI(data?.data)
//            val bm = (testImg.getDrawable() as BitmapDrawable).bitmap
            val bm = testImg.getDrawable().toBitmap()
            img = bm
        }
    }






}
