package com.android.example.kinrai

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row_resterant.view.*
import kotlin.collections.ArrayList
import android.graphics.Bitmap.CompressFormat
import java.io.ByteArrayOutputStream
import android.graphics.*
import android.util.Log


class listAdapter(val context: Context) : RecyclerView.Adapter<listAdapter.ViewHolder>() {

    var data = ArrayList<Resterant>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    fun encodeImg(img: Bitmap): ByteArray {
        val outputStream = ByteArrayOutputStream()
        img.compress(CompressFormat.PNG, 0, outputStream)
        return outputStream.toByteArray()
    }

    fun decodeImg(imgStr: ByteArray): Bitmap {

        var result: Bitmap
        Log.i("Image", imgStr.toString())
        var width = 200
        var height = width
        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        val paint = Paint()
        paint.setColor(Color.GREEN)
        canvas.drawRect(0f, 0f, width.toFloat(), height.toFloat(), paint)
        result = bitmap

        if (imgStr.isNotEmpty() and (imgStr.size > 0)) {
            result = BitmapFactory.decodeByteArray(imgStr, 0, imgStr.size)
        }


        return result

    }


    override fun onBindViewHolder(item: ViewHolder, index: Int) {
        Log.i("Image",data[index].photo.size.toString())
        item?.name?.text = data[index].toString()
        item?.photo?.setImageBitmap(decodeImg(data[index].photo))

    }


    override fun getItemCount(): Int {

        return data.size
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.row_resterant, p0, false))
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.res_name
        val photo = itemView.res_image


        init {
            itemView.setOnClickListener { view: View ->

                view.findNavController().navigate(R.id.action_listFragment_to_map)


            }


        }
    }


}