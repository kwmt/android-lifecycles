package com.example.android.lifecycles.arap_osaka.fragmentToActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android.codelabs.lifecycle.R

class ActivityFromFragmentActivity : AppCompatActivity(), ToActivityFragment.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_from_fragment)
    }

    override fun onClick() {
        // なにか
    }
}
