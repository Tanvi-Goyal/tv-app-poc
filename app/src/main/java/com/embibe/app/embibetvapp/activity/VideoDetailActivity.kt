package com.embibe.app.embibetvapp.activity

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.embibe.app.embibetvapp.R

class VideoDetailActivity : FragmentActivity() {

    companion object {
        const val SHARED_ELEMENT_NAME = "video"
        const val ITEM_ID = "item_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_detail)
    }
}
