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

package com.example.android.lifecycles.practice.share_viewmodel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.android.codelabs.lifecycle.R

/**
 * Shows a SeekBar that should be synced with a value in a ViewModel.
 */
class Fragment_step5 : Fragment() {

    private var mSeekBar: SeekBar? = null

    private val mSeekBarViewModel: SeekBarViewModel by viewModels({ requireActivity() })

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_step5, container, false)
        mSeekBar = root.findViewById(R.id.seekBar)

        subscribeSeekBar()

        return root
    }

    private fun subscribeSeekBar() {

        // Update the ViewModel when the SeekBar is changed.

        mSeekBar?.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                mSeekBarViewModel.seekbarValue.value = progress
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}

            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })

        // TODO: Update the SeekBar when the ViewModel is changed.
        // mSeekBarViewModel.seekbarValue.observe(...
        mSeekBarViewModel.seekbarValue.observe(viewLifecycleOwner, Observer {
            mSeekBar?.progress = it
        })
    }
}
