package com.example.android.lifecycles.arap_osaka.viewmodel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider

import com.example.android.codelabs.lifecycle.R

class DestinationFragment : Fragment() {

    companion object {
        fun newInstance() = DestinationFragment()
    }

    private lateinit var viewModel: DestinationViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.destination_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DestinationViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
