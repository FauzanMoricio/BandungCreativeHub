package com.moriss.bandungcreativehub

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import com.moriss.bandungcreativehub.adapter.AdapterUlasan
import com.moriss.bandungcreativehub.adapter.Komen

class Ulasan : Fragment() {

    private lateinit var commentsRecyclerView: RecyclerView
    private lateinit var commentAdapter: AdapterUlasan
    private lateinit var comments: MutableList<Komen>
    private lateinit var database: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ulasan, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        database = FirebaseDatabase.getInstance().getReference("comments")
        commentsRecyclerView = view.findViewById(R.id.commentsRecyclerView)
        commentsRecyclerView.layoutManager = LinearLayoutManager(context)

        comments = mutableListOf()
        commentAdapter = AdapterUlasan(comments)
        commentsRecyclerView.adapter = commentAdapter

        val usernameEditText = view.findViewById<EditText>(R.id.usernameEditText)
        val commentEditText = view.findViewById<EditText>(R.id.commentEditText)
        val addCommentButton = view.findViewById<Button>(R.id.addCommentButton)

        addCommentButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val comment = commentEditText.text.toString()

            if (username.isNotEmpty() && comment.isNotEmpty()) {
                val newComment = Komen(username, comment)
                saveComment(newComment)
                usernameEditText.text.clear()
                commentEditText.text.clear()
            }
        }

        loadComments()
    }

    private fun loadComments() {
        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                comments.clear()
                for (commentSnapshot in snapshot.children) {
                    val comment = commentSnapshot.getValue(Komen::class.java)
                    if (comment != null) {
                        comments.add(comment)
                    }
                }
                commentAdapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                // Handle error
            }
        })
    }

    private fun saveComment(comment: Komen) {
        val commentId = database.push().key
        if (commentId != null) {
            database.child(commentId).setValue(comment)
        }
    }
}
