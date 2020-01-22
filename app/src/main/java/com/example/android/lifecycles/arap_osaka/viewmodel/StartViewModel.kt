package com.example.android.lifecycles.arap_osaka.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StartViewModel : ViewModel() {
    private val _nextView = MutableLiveData<Boolean>(false)
    val nextView: LiveData<Boolean> = _nextView

    fun onClickNextButton() {
        if (true) {
            _nextView.value = true
        } else {
            _nextView.value = false
        }
    }
}
