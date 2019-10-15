package com.embibe.app.embibetvapp.activity

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.util.Log
import com.embibe.app.embibetvapp.BuildConfig
import com.embibe.app.embibetvapp.model.ObjectBox
import com.embibe.app.embibetvapp.model.ObjectBox.boxStore
import io.objectbox.android.AndroidObjectBrowser

class App : Application() {
    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = this
        ObjectBox.init(this)
        if (BuildConfig.DEBUG) {
            val started = AndroidObjectBrowser(boxStore).start(context)
            Log.i("ObjectBrowser", "Started: $started")
        }

    }
}