package com.example.sampletv.utils

import android.content.Context
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
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
class PerformanceCardPresenter(context: Context) : AbstractCardPresenter<BaseCardView>(context) {

    override fun onCreateView(): BaseCardView {
        val cardView = BaseCardView(context, null)
        cardView.isFocusable = true
        cardView.addView(LayoutInflater.from(context).inflate(R.layout.item_performance_card, null))
        return cardView
    }

    override fun onBindViewHolder(card: Any, cardView: BaseCardView) {
        val imageView = cardView.findViewById<ImageView>(R.id.image)
        val title = cardView.findViewById<TextView>(R.id.textCardTitle)
        val labelOne = cardView.findViewById<TextView>(R.id.labelOne)
        val descOne = cardView.findViewById<TextView>(R.id.labelPercentageOne)
        val labelTwo = cardView.findViewById<TextView>(R.id.labelTwo)
        val descTwo = cardView.findViewById<TextView>(R.id.labelPercentageTwo)
//        val seekBarOne = cardView.findViewById<SeekBar>(R.id.viewOne)
//        val seekBarTwo = cardView.findViewById<SeekBar>(R.id.viewTwo)

        val mycard = card as Card
        Glide.with(context)
            .asBitmap()
            .load(R.drawable.ic_target)
            .into(imageView)
        title.text = mycard.title
        labelOne.text = mycard.subTitleOne
        descOne.text = mycard.subDescOne
        labelTwo.text = mycard.subTitleTwo
        descTwo.text = mycard.subDescTwo
//        seekBarOne.progress = card.subDescOne.toInt()
//        seekBarTwo.progress = card.subDescTwo.toInt()
    }

}
