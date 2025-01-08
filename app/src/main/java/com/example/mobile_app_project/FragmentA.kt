package com.example.mobile_app_project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class FragmentA : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val fragmentView = inflater.inflate(R.layout.fragment, container, false)

        // Set text for the TextView
        val textView = fragmentView.findViewById<TextView>(R.id.tv_fragment_label)
        textView.text = "FragmentA"

        return fragmentView
    }
}
