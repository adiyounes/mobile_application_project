package com.example.mobile_app_project
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class FragmentB : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the fragment layout
        val fragmentRoot = inflater.inflate(R.layout.fragment, container, false)

        // Update the label text
        fragmentRoot.findViewById<TextView>(R.id.tv_fragment_label).apply {
            text = "FragmentB"
        }

        return fragmentRoot
    }
}
