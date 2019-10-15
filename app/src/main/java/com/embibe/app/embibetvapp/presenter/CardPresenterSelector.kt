/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 *
 */

package com.embibe.app.embibetvapp.presenter

import android.content.ClipData
import android.content.Context
import androidx.leanback.widget.Presenter
import androidx.leanback.widget.PresenterSelector
import com.embibe.app.embibetvapp.model.Card
import com.embibe.app.embibetvapp.model.Item
import java.util.*

/**
 * This PresenterSelector will decide what Presenter to use depending on a given card's type.
 */
class CardPresenterSelector(private val mContext: Context) : PresenterSelector() {

    private val presenters = HashMap<Card.Type, Presenter?>()

    override fun getPresenter(item: Any): Presenter? {
        if (item !is Item)
            throw RuntimeException(
                String.format(
                    "The PresenterSelector only supports data items of type '%s'",
                    Item::class.java.name
                )
            )
        var presenter = presenters[item.type]
        if (presenter == null) {
            when (item.type) {
                else -> presenter = ImageCardViewPresenter(mContext)
            }
        }
        presenters[item.type] = presenter
        return presenter
    }

}
