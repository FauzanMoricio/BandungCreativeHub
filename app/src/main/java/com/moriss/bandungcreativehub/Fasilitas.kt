package com.moriss.bandungcreativehub

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.moriss.bandungcreativehub.adapter.AdapterFasilitas
import com.moriss.bandungcreativehub.adapter.Gambar

class Fasilitas : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fasilitas, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val galleryList = listOf(
            Gambar(R.drawable.d_lantai1, getString(R.string.d1)),
            Gambar(R.drawable.d_lantai2, getString(R.string.d2)),
            Gambar(R.drawable.d_lantai3, getString(R.string.d3)),
            Gambar(R.drawable.d_lantai4, getString(R.string.d4)),
            Gambar(R.drawable.d_lantai5, getString(R.string.d5)),

            Gambar(R.drawable.f_musik, getString(R.string.f1)),
            Gambar(R.drawable.f_seni, getString(R.string.f2)),
            Gambar(R.drawable.f_rapat, getString(R.string.f3)),
            Gambar(R.drawable.f_perpus, getString(R.string.f4)),
            Gambar(R.drawable.f_audito, getString(R.string.f5))
        )

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = AdapterFasilitas(requireContext(), galleryList)
    }
}

