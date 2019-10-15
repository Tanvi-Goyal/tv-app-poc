/*
 * Copyright (c) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.embibe.app.embibetvapp.activity

import android.os.Bundle
import android.view.KeyEvent
import androidx.fragment.app.FragmentActivity
import com.embibe.app.embibetvapp.R
import com.embibe.app.embibetvapp.fragment.SearchVideoFragment


/*
 * SearchActivity for SearchFragment
 */
class SearchActivity : FragmentActivity() {
    private lateinit var mFragment: SearchVideoFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        mFragment = supportFragmentManager.findFragmentById(R.id.search_fragment) as SearchVideoFragment
    }



    override fun onSearchRequested(): Boolean {
        if (mFragment.hasResults()) {
           // startActivity(Intent(this, SearchActivity::class.java))
        } else {
            mFragment.startRecognition()
        }
        return true
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        // If there are no results found, press the left key to reselect the microphone
        if (keyCode == KeyEvent.KEYCODE_DPAD_LEFT && !mFragment.hasResults()) {
            mFragment.focusOnSearch()
        }
        return super.onKeyDown(keyCode, event)
    }
}
