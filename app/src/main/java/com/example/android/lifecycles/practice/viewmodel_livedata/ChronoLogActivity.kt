/*
 * Copyright 2019, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.lifecycles.practice.viewmodel_livedata

import android.app.AlertDialog
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.android.codelabs.lifecycle.R
import com.example.android.lifecycles.LifeCycleLogActivity
import kotlinx.android.synthetic.main.activity_main.activity_main
import timber.log.Timber

class ChronoLogActivity : LifeCycleLogActivity() {

    companion object {
        private var innerClass: SomeInnerClass? = null
    }

//    private val viewModel by viewModels<ChronoViewModel>()
    private lateinit var viewModel : ChronoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(ChronoViewModel::class.java)

        activity_main.addView(Button(this).apply {
            setText("postValueのgetValue")
            setOnClickListener {
                AlertDialog.Builder(this@ChronoLogActivity).apply {
                    setTitle("value")
                    setMessage("${viewModel.getNoObserveLiveData().value}")
                }.create().show()
            }
        })

        val timerTextView: TextView = findViewById(R.id.timer_textview)
        viewModel.getElapsedTime().observe(this, Observer {
            timerTextView.text = "${it}秒経過"
        })

        Timber.d("setValueのgetValue:${viewModel.getElapsedTime().value}")
        Timber.d("No Observe postValueのgetValue:${viewModel.getNoObserveLiveData().value}")

//        viewModel.timerTextView = timerTextView
//        viewModel.activity = this
//
////        singletonSampleClass = SingletonSampleClass.getInstance(this)
//
////        if(innerClass == null) {
////            innerClass = SomeInnerClass()
////        }
////        ModelLocator.instance.singleton?.textView = timerTextView
    }

    override fun onDestroy() {
        super.onDestroy()
//        singletonSampleClass.onDestroy()
    }

    internal inner class SomeInnerClass {
        fun doSomething() {}
    }
}
