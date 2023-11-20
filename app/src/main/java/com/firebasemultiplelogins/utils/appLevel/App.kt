package com.firebasemultiplelogins.utils.appLevel

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {

    companion object {
        const val APP_ID = "582097DB-E611-48D8-816E-36F5A21B476C"
        lateinit var instance: App
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}