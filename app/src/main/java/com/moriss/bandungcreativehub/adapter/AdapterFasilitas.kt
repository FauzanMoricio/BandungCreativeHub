package com.moriss.bandungcreativehub.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.moriss.bandungcreativehub.R

data class Gambar (val imageResId: Int, val title: String)

class AdapterFasilitas(
    private val context: Context,
    private val galleryList: List<Gambar>
) : RecyclerView.Adapter<AdapterFasilitas.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageFasi)
        val titleText: TextView = itemView.findViewById(R.id.txFasi)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_fasilitas, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = galleryList[position]
        holder.imageView.setImageResource(item.imageResId)
        holder.titleText.text = item.title
    }

    override fun getItemCount(): Int {
        return galleryList.size
    }
}
