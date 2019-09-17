package com.example.android.lifecycles.practice

import android.content.Context
import android.widget.TextView
import org.jetbrains.annotations.NotNull

class Singleton {
    var textView: TextView? = null

    fun run(r: Runnable) {
    }
}

class SingletonSampleClass private constructor(private var context: Context?) {

    fun onDestroy() {
        if (context != null) {
            context = null
        }
    }

    companion object {
        private  var instance: SingletonSampleClass? = null

        @Synchronized
        fun getInstance(context: Context): SingletonSampleClass {
            if(instance == null)
                instance = SingletonSampleClass(context)
            return instance!!
        }
    }
}