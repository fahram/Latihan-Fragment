package com.fahram.latihanfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment


class HomeFragment : Fragment() {

    lateinit var btnMoveToDetailFragment: Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnMoveToDetailFragment = view.findViewById(R.id.btn_move_to_detail_fragment)
        btnMoveToDetailFragment.setOnClickListener {
            val fragmentManager = parentFragmentManager
            val detailFragment = DetailFragment()
            val bundle = Bundle()
            bundle.putString(DetailFragment.EXTRA_NIM, "202022112")
            detailFragment.arguments = bundle
            detailFragment.nama = "Khaidir Fahram"

            fragmentManager.beginTransaction().apply {
                replace(R.id.container, detailFragment, DetailFragment::class.java.simpleName)
                    .addToBackStack(null)
                    .commit()
            }
        }
    }
}