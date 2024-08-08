package com.moriss.bandungcreativehub.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.moriss.bandungcreativehub.R

data class Komen(val username: String = "", val comment: String = "")

class AdapterUlasan(private val comments: List<Komen>) : RecyclerView.Adapter<AdapterUlasan.CommentViewHolder>() {

    class CommentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val usernameTextView: TextView = itemView.findViewById(R.id.txnama)
        val commentTextView: TextView = itemView.findViewById(R.id.txKomentar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_ulasan, parent, false)
        return CommentViewHolder(view)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        val comment = comments[position]
        holder.usernameTextView.text = comment.username
        holder.commentTextView.text = comment.comment
    }

    override fun getItemCount() = comments.size
}


