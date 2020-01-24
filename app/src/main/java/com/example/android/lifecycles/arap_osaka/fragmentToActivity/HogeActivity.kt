package com.example.android.lifecycles.arap_osaka.fragmentToActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.observe
import com.example.android.codelabs.lifecycle.R
import kotlinx.android.synthetic.main.activity_from_fragment.textView

class HogeActivity : AppCompatActivity(), FugaFragment.OnClickListener {

    private val viewModel by viewModels<HogeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_from_fragment)

        viewModel.clickEvent.observe(this) {
            textView.text = it
        }
    }

    override fun onClick() {
        // なにか
    }
}
