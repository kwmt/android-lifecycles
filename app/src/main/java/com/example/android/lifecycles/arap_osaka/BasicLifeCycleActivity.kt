package com.example.android.lifecycles.arap_osaka

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.findNavController
import com.example.android.codelabs.lifecycle.R
import com.example.android.lifecycles.LifeCycleLogActivity
import kotlinx.android.synthetic.main.activity_basic_lifecycle.fab
import kotlinx.android.synthetic.main.activity_basic_lifecycle.toolbar

class BasicLifeCycleActivity : LifeCycleLogActivity() {

    private val fragment1: Fragment by lazy {
        BasicLifeCycleLogFragment()
    }
    private val fragment2: Fragment by lazy {
        BasicLifeCycleLogFragment2()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_lifecycle)
        setSupportActionBar(toolbar)
        fab.setOnClickListener { view ->
            findNavController(R.id.nav_host_container).navigate(R.id.basicLifeCycleLogFragment2)

        }
    }

    private fun replace(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commitNow()
    }

    private fun detachNavHostFragment(
        fragmentManager: FragmentManager,
        navHostFragment: Fragment
    ) {
        fragmentManager.beginTransaction()
            .detach(navHostFragment)
            .commitNow()
    }

    private fun attachNavHostFragment(
        fragmentManager: FragmentManager,
        navHostFragment: Fragment,
        isPrimaryNavFragment: Boolean
    ) {
        fragmentManager.beginTransaction()
            .attach(navHostFragment)
            .apply {
                if (isPrimaryNavFragment) {
                    setPrimaryNavigationFragment(navHostFragment)
                }
            }
            .commitNow()
    }
}

