/*
 * Copyright (c) 2015 The Android Open Source Project
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

package com.embibe.app.embibetvapp.presenter

import androidx.leanback.widget.AbstractDetailsDescriptionPresenter
import com.embibe.app.embibetvapp.App
import com.embibe.app.embibetvapp.R

import com.embibe.app.embibetvapp.model.Item

class DetailsDescriptionPresenter : AbstractDetailsDescriptionPresenter() {

    override fun onBindDescription(viewHolder: ViewHolder, item: Any) {
        val video = item as Item
        viewHolder.title.text = video.title
        if (video.contentDescription.isNotEmpty())
            viewHolder.body.text = video.contentDescription
        else
            viewHolder.body.text = App.context.getText(R.string.dummy_string)
    }
}
