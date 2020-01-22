package com.example.android.lifecycles.arap_osaka

import org.junit.Before
import org.junit.Test

import com.example.android.lifecycles.arap_osaka.viewmodel.StartViewModel

class StartViewModelTest {
    private lateinit var target: StartViewModel

    @Before
    fun setUp() {
        target = StartViewModel()
    }

    @Test
    fun onClickNextButton() {
        //target.nextView.observe()
        target.onClickNextButton()
    }
}
