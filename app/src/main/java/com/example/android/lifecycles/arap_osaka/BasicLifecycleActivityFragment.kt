package com.example.android.lifecycles.arap_osaka

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android.codelabs.lifecycle.R

/**
 * A placeholder fragment containing a simple view.
 */
class BasicLifecycleActivityFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_basic_lifecycle, container, false)
    }
}
