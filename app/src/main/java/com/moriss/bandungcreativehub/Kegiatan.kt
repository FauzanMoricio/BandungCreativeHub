package com.moriss.bandungcreativehub

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.moriss.bandungcreativehub.adapter.AdapterKegiatan
import com.moriss.bandungcreativehub.adapter.Gallery

class Kegiatan : Fragment() {

    private lateinit var horizontalAdapter: AdapterKegiatan
    private lateinit var horizontalRecyclerView: RecyclerView
    private lateinit var galleryList: List<Gallery>
    private lateinit var gbSitus: ImageView
    private lateinit var gbIg: ImageView
    private lateinit var txsitus: TextView
    private lateinit var txInsta: TextView

    private lateinit var webViewMap: WebView
    private lateinit var tvAddress: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kegiatan, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataInitialize()

        // Untuk Horizontal RecyclerView
        val horizontalLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        horizontalRecyclerView = view.findViewById(R.id.horizontal_recycler_view)
        horizontalRecyclerView.layoutManager = horizontalLayoutManager
        horizontalRecyclerView.setHasFixedSize(true)
        horizontalAdapter = AdapterKegiatan(requireContext(), galleryList)
        horizontalRecyclerView.adapter = horizontalAdapter

        // Untuk webview
        webViewMap = view.findViewById(R.id.Map)
        webViewMap.settings.javaScriptEnabled = true
        val mapUrl = "https://www.google.com/maps?q=Jl.+Laswi+No.7,+Kacapiring,+Kec.+Batununggal,+Kota+Bandung,+Jawa+Barat+40271"
        webViewMap.loadUrl(mapUrl)


        // Untuk Alamat textview
        tvAddress = view.findViewById(R.id.alamat)
        tvAddress.setOnClickListener {
            val address = "Jl. Laswi No.7, Kacapiring, Kec. Batununggal, Kota Bandung, Jawa Barat 40271"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://maps.app.goo.gl/n1DLEjNqesW57hJ79"))
            startActivity(intent)
        }

        // Untuk Situs textview
        txsitus = view.findViewById(R.id.situs)
        txsitus.setOnClickListener {
            val Situs = "creativehub_bdg"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://linktr.ee/creativehub_bdg"))
            startActivity(intent)
        }

        // Untuk Instagram textview
        txInsta = view.findViewById(R.id.instagram)
        txInsta.setOnClickListener {
            val IG = "creativehub.bdg"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/creativehub.bdg/"))
            startActivity(intent)
        }

        // Untuk Situs Icon Image
        gbSitus = view.findViewById(R.id.iconsitus)
        gbSitus.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://linktr.ee/creativehub_bdg"))
            startActivity(intent)
        }

        // Untuk Instagram Icon Image
        gbIg = view.findViewById(R.id.iconig)
        gbIg.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/creativehub.bdg/"))
            startActivity(intent)
        }

    }

    private fun dataInitialize() {
        galleryList = listOf(
            Gallery(R.drawable.jd1),
            Gallery(R.drawable.jd4),
            Gallery(R.drawable.jd3),
            Gallery(R.drawable.jd2)
        )
    }
}
