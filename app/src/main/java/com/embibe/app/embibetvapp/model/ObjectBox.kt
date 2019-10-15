package com.embibe.app.embibetvapp.model

import android.content.Context
import io.objectbox.BoxStore

object ObjectBox {

    lateinit var boxStore: BoxStore private set

    fun init(context: Context): BoxStore {
        if (::boxStore.isInitialized && !boxStore.isClosed) {
            return boxStore
        }

        boxStore = MyObjectBox.builder().androidContext(context.applicationContext).build()
        return boxStore
    }
}