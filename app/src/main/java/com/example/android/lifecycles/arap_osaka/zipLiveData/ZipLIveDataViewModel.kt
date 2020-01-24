package com.example.android.lifecycles.arap_osaka.zipLiveData

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel

class ZipLIveDataViewModel : ViewModel() {

    val editText1 = MutableLiveData<String>()
    val editText2 = MutableLiveData<String>()

    val isEnabled = MediatorLiveData<Boolean>()

    init {
        val observer = Observer<String> {
            isEnabled.value = editText1.value?.isNotEmpty() ?: false
                    && editText2.value?.isNotEmpty() ?: false
        }

        isEnabled.addSource(editText1, observer)
        isEnabled.addSource(editText2, observer)
    }
}
