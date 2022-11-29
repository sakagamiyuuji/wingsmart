package com.test.wingsmart.app

import android.app.Application
import androidx.lifecycle.LifecycleObserver
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication : Application(), LifecycleObserver {

    override fun onCreate() {
        super.onCreate()
    }
}

