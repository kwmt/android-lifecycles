package com.example.android.lifecycles.arap_osaka.livedata.ok

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.android.codelabs.lifecycle.R
import com.example.android.lifecycles.arap_osaka.livedata.model.NextViewType
import timber.log.Timber

class DestinationFragment : Fragment() {

    companion object {
        fun newInstance() = DestinationFragment()
    }

    private val viewModel: DestinationViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.destination_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val nextViewType = arguments?.getSerializable("nextViewType") as? NextViewType
                ?: return
        Timber.d("$nextViewType")
    }

}
