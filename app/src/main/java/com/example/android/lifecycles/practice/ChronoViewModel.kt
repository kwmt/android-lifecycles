package com.example.android.lifecycles.practice

import androidx.lifecycle.ViewModel
import timber.log.Timber

class ChronoViewModel: ViewModel() {

    init {
        Timber.d("ChronoViewModel created")
    }

    var startTime: Long? = null

    override fun onCleared() {
        super.onCleared()
        Timber.d("onCleare")
    }
}