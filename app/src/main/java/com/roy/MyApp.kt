package com.roy

import android.app.Application
import com.roy.ext.setupApplovinAd

//TODO firebase
//TODO animation
//done
//ic_launcher
//status bar color
//remove full screen
//rate app
//more app
//share app
//policy
//proguard
//add back button
//app version
//leak canary
//keystore
//ad id
//ad applovin
class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()

        this.setupApplovinAd()
    }
}
