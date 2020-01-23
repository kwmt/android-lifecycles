package com.example.android.lifecycles.practice.viewmodel_livedata

import android.os.Handler
import android.os.Looper
import android.os.SystemClock
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber
import java.util.Timer
import java.util.TimerTask

class ChronoViewModel : ViewModel() {

    private val initialTime = SystemClock.elapsedRealtime()
    private val timer = Timer()

    private val elapsedTime = MutableLiveData<Long>()
    fun getElapsedTime(): LiveData<Long> = elapsedTime

    private val noObserveLiveData = MutableLiveData<String>()
    fun getNoObserveLiveData(): LiveData<String> = noObserveLiveData

    private val handler = Handler(Looper.getMainLooper())

    init {
        Timber.d("ChronoViewModel created")

        timer.scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                val newValue = (SystemClock.elapsedRealtime() - initialTime) / 1000;

                handler.post {
                    elapsedTime.value = newValue
                }


                noObserveLiveData.postValue("${newValue} 秒？")
            }
        }, 1000, 1000)
    }

    override fun onCleared() {
        super.onCleared()
        Timber.d("onCleared")
    }
}
