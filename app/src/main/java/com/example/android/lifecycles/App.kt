package com.example.android.lifecycles

import android.app.Activity
import android.app.Application
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.android.lifecycles.practice.viewmodel_livedata.ChronoViewModel
import timber.log.Timber
import timber.log.Timber.DebugTree

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(DebugTree())

        val vp = ViewModelProvider.AndroidViewModelFactory.getInstance(this).create(ChronoViewModel::class.java)
        Timber.d("$vp")

        registerActivityLifecycleCallbacks(object: ActivityLifecycleCallbacks{
            override fun onActivityPaused(activity: Activity?) {
                Timber.d("onActivityPaused $activity")
            }

            override fun onActivityResumed(activity: Activity?) {
                Timber.d("onActivityResumed $activity")
            }

            override fun onActivityStarted(activity: Activity?) {
                Timber.d("onActivityStarted $activity")
            }

            override fun onActivityDestroyed(activity: Activity?) {
                Timber.d("onActivityDestroyed $activity")
            }

            override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {
                Timber.d("onActivitySaveInstanceState $activity")
            }

            override fun onActivityStopped(activity: Activity?) {
                Timber.d("onActivityStopped $activity")
            }

            override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) {
                Timber.d("onActivityCreated $activity")
            }
        })
    }

    override fun onTerminate() {
        super.onTerminate()
        Timber.d("onTerminate")
        val vp = ViewModelProvider.AndroidViewModelFactory.getInstance(this).create(ChronoViewModel::class.java)
        Timber.d("$vp")



    }
}