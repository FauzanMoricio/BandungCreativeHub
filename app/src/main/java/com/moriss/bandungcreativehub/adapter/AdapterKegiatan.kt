package com.moriss.bandungcreativehub.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.moriss.bandungcreativehub.R

data class Gallery(val imageResId: Int)

class AdapterKegiatan(
    private val context: Context,
    private val imageList: List<Gallery>
) : RecyclerView.Adapter<AdapterKegiatan.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_kegiatan, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val galleryItem = imageList[position]
        holder.imageView.setImageResource(galleryItem.imageResId)
    }

    override fun getItemCount(): Int {
        return imageList.size
    }


}
