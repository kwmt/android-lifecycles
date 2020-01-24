package com.example.android.lifecycles.arap_osaka.fragmentToActivity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.viewModels
import com.example.android.codelabs.lifecycle.R
import com.example.android.lifecycles.arap_osaka.livedata.model.NextViewType
import timber.log.Timber

class FugaFragment : Fragment() {

    interface OnClickListener {
        fun onClick()
    }

    private val viewModel by viewModels<HogeViewModel> ({ requireActivity() })

    private var onClickListener: OnClickListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return Button(this.requireContext()).apply {
            text = "Fragmentのボタン"
            textSize = 40f
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        onClickListener = requireActivity() as? OnClickListener
        // なにか
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.setOnClickListener {
            viewModel.onClick()
        }

    }
}
