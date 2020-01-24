package com.example.android.lifecycles.arap_osaka.fragmentToActivity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.android.codelabs.lifecycle.R
import com.example.android.lifecycles.arap_osaka.livedata.model.NextViewType
import timber.log.Timber

class ToActivityFragment : Fragment() {

    interface OnClickListener {
        fun onClick()
    }

    private var onClickListener: OnClickListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return View(this.requireContext())
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        onClickListener = requireActivity() as? OnClickListener
        // なにか
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}
