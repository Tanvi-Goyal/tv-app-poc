package com.embibe.app.embibetvapp.presenter

import android.content.Context
import android.view.ContextThemeWrapper
import android.view.LayoutInflater
import android.widget.ImageView
import androidx.leanback.widget.BaseCardView
import androidx.leanback.widget.ImageCardView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.embibe.app.embibetvapp.R
import com.embibe.app.embibetvapp.model.Item

/**
 * A very basic [ImageCardView] [androidx.leanback.widget.Presenter].You can
 * pass a custom style for the ImageCardView in the constructor. Use the default constructor to
 * create a Presenter with a default ImageCardView style.
 */
class ImageCardViewPresenter @JvmOverloads constructor(
    context: Context, cardThemeResId: Int = R.style.DefaultCardTheme
) : AbstractCardPresenter<BaseCardView>(ContextThemeWrapper(context, cardThemeResId)) {


    override fun onCreateView(): BaseCardView {
        val cardView = BaseCardView(context, null, R.style.SingleLineCardTheme)
        cardView.isFocusable = true
        cardView.addView(
            LayoutInflater.from(context).inflate(
                R.layout.dashboard_cardview_item,
                null
            )
        )
        return cardView
    }


    override fun onBindViewHolder(card: Any, cardView: BaseCardView) {
        val imageView = cardView.findViewById<ImageView>(R.id.main_image)
        val width = context.resources
            .getDimension(R.dimen.movie_image_card_width).toInt()
        val height = context.resources
            .getDimension(R.dimen.movie_image_card_height).toInt()
        val myCard = card as Item
        val myOptions = RequestOptions().override(width, height)
        Glide.with(context)
            .load(myCard.thumbnails)
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
            .apply(myOptions)
            .into(imageView)
    }
}
