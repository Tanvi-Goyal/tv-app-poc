package com.example.sampletv.utils

import android.content.Context
import android.view.LayoutInflater
import android.widget.ImageView
import androidx.leanback.widget.BaseCardView
import com.bumptech.glide.Glide
import com.embibe.app.embibetvapp.R
import com.embibe.app.embibetvapp.model.Card
import com.embibe.app.embibetvapp.presenter.AbstractCardPresenter

/**
 * This Presenter will display a card consisting of an image on the left side of the card followed
 * by text on the right side. The image and text have equal width. The text will work like a info
 * box, thus it will be hidden if the parent row is inactive. This behavior is unique to this card
 * and requires a special focus handler.
 */
class ChartPresenter(context: Context) : AbstractCardPresenter<BaseCardView>(context) {

    override fun onCreateView(): BaseCardView {
        val cardView = BaseCardView(
            context, null)
//        cardView.isFocusable = true
        cardView.addView(LayoutInflater.from(context).inflate(R.layout.item_chart, null))
        return cardView
    }

    override fun onBindViewHolder(card: Any, cardView: BaseCardView) {
//        val imageView = cardView.findViewById<ImageView>(R.id.main_image)
//        if (card.getLocalImageResourceName() != null) {
//            val resourceId = context.resources
//                .getIdentifier(
//                    card.getLocalImageResourceName(),
//                    "drawable", context.packageName
//                )
//            Glide.with(context)
//                .asBitmap()
//                .load(resourceId)
//                .into(imageView)
//        }
    }
}
