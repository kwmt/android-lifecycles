package com.example.android.lifecycles

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import timber.log.Timber

abstract class LifeCycleLogActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.d("onCreate: savedInstanceState=$savedInstanceState")
    }

    override fun onStart() {
        super.onStart()
        Timber.d("onStart")
    }

    override fun onResume() {
        super.onResume()
        Timber.d("onResume")
    }

    override fun onPause() {
        Timber.d("onPause")
        super.onPause()
        Timber.d("onPause after super.onPause")
    }

    override fun onStop() {
        Timber.d("onStop")
        super.onStop()
        Timber.d("onStop after super.onStop")
    }

    override fun onDestroy() {
        Timber.d("onDestroy")
        super.onDestroy()
        Timber.d("onDestroy after super.onDestroy")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Timber.d("onSaveInstanceState")
    }

    override fun onRestart() {
        super.onRestart()
        Timber.d("onRestart")
    }

    override fun finish() {
        Timber.d("finish")
        super.finish()
    }
}