package com.example.android.lifecycles.arap_osaka

import android.os.Bundle
import androidx.navigation.findNavController
import com.example.android.codelabs.lifecycle.R
import com.example.android.lifecycles.LifeCycleLogActivity
import kotlinx.android.synthetic.main.activity_basic_lifecycle.fab
import kotlinx.android.synthetic.main.activity_basic_lifecycle.toolbar
import timber.log.Timber

class BasicLifeCycleActivity : LifeCycleLogActivity(), ALifeCycleLogFragment.OnClickTextView {
    override fun onClick(text: String) {
        Timber.d("$text")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_lifecycle)
        setSupportActionBar(toolbar)
        fab.setOnClickListener { view ->
            findNavController(R.id.nav_host_container).navigate(R.id.bLifeCycleLogFragment)
        }

//        GlobalScope.launch {
//            delay(1000)
//
//        }

//        finish()
    }
}

