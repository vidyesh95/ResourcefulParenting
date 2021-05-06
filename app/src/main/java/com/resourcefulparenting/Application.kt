package com.resourcefulparenting

import android.app.Application
import android.os.Bundle
import timber.log.Timber

class Application:Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}