package com.example.android.lifecycles.arap_osaka.zipLiveData

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.android.codelabs.lifecycle.R
import com.example.android.codelabs.lifecycle.databinding.ActivityZipLiveDataBinding
import kotlinx.android.synthetic.main.activity_zip_live_data.editText1

class ZipLiveDataActivity : AppCompatActivity() {

    private val viewModel by viewModels<ZipLIveDataViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityZipLiveDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_zip_live_data)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
    }
}
