package com.example.android.lifecycles.arap_osaka.fragmentToActivity

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HogeViewModel : ViewModel() {
    val clickEvent = MutableLiveData<String>()
    fun onClick() {
        clickEvent.value = "ボタンが押されたよ"
    }
}
