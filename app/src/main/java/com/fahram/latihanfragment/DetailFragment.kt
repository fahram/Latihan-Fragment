package com.fahram.latihanfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class DetailFragment : Fragment() {

    var nama: String? = null

    companion object {
        const val EXTRA_NIM = "extra_nim"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tvNim = view.findViewById<TextView>(R.id.tvNim)
        val tvNama = view.findViewById<TextView>(R.id.tvName)
        tvNama.text = nama

        if (arguments != null) {
            val nim = arguments?.getString(EXTRA_NIM)
            tvNim.text = nim
        }

        val btnDialog = view.findViewById<Button>(R.id.btn_open_dialog)
        btnDialog.setOnClickListener {
            val dialogFragment = PopUpFragment()
            val fragmentManager = childFragmentManager
            dialogFragment.show(fragmentManager, PopUpFragment::class.java.simpleName)
        }
    }
}