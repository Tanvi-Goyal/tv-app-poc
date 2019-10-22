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
//        if (item !is Card || item !is Item)
//            throw RuntimeException(
//                String.format(
//                    "The PresenterSelector only supports data items of type '%s'",
//                    Card::class.java.name
//                )
//            )

        if (item is Card) {
            val myItem = item as Card
            var presenter = presenters[myItem.type]
            if (presenter == null) {
                presenter = when (myItem.type) {
                    Card.Type.PERFORMANCE -> PerformanceCardPresenter(mContext)
                    Card.Type.CHART -> ChartPresenter(mContext)
                    else -> ImageCardViewPresenter(mContext)
                }
            }
            presenter?.let { myItem.type?.let { it1 -> presenters.put(it1, it) } }
            return presenter
        }

        if (item is Item) {
            val myItem = item as Item
            var presenter = presenters[myItem.type]
            if (presenter == null) {
                presenter = when (myItem.type) {
                    Card.Type.PERFORMANCE -> PerformanceCardPresenter(mContext)
                    Card.Type.CHART -> ChartPresenter(mContext)
                    else -> ImageCardViewPresenter(mContext)
                }
            }
            presenter?.let { myItem.type?.let { it1 -> presenters.put(it1, it) } }
            return presenter
        }
        return null
    }

}
