package com.example.android.lifecycles.arap_osaka.livedata.ok

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import com.example.android.codelabs.lifecycle.R

class StartFragment : Fragment() {

    companion object {
        fun newInstance() = StartFragment()
    }

    private val viewModel: StartViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.start_fragment, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.nextButton).setOnClickListener {
            viewModel.onClickNextButton()
        }

        viewModel.nextLiveData.observe(viewLifecycleOwner) { event ->
            event.getContentIfNotHandled()?.let { nextViewType ->
                findNavController().navigate(R.id.destinationFragment,
                        Bundle().apply { putSerializable("nextViewType", nextViewType) })
            }
        }
    }
}
