package com.example.android.lifecycles.arap_osaka

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android.codelabs.lifecycle.R
import com.example.android.lifecycles.LifeCycleLogFragment
import timber.log.Timber

/**
 * A placeholder fragment containing a simple view.
 */
class BasicLifeCycleLogFragment2 : LifeCycleLogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Timber.tag("LifeCycleLogFragment").d("BasicLifeCycleLogFragment2 onCreateView: $savedInstanceState")
        return inflater.inflate(R.layout.fragment_basic_lifecycle2, container, false)
    }
}
