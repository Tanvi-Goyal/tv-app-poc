package com.embibe.app.embibetvapp.fragment


import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.leanback.app.BackgroundManager
import androidx.leanback.app.RowsSupportFragment
import androidx.leanback.widget.*
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions.bitmapTransform
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.embibe.app.embibetvapp.awsUtils.S3Utils
import com.embibe.app.embibetvapp.model.Item
import com.embibe.app.embibetvapp.model.ObjectBox
import com.embibe.app.embibetvapp.model.Videos
import com.embibe.app.embibetvapp.presenter.CardPresenterSelector
import com.embibe.app.embibetvapp.presenter.ShadowRowPresenterSelector
import com.embibe.app.embibetvapp.utils.BlurTransformation
import com.embibe.app.embibetvapp.utils.CardListRow
import io.objectbox.Box

/**
 * A simple [Fragment] subclass.
 */
class HomeRowFragment : RowsSupportFragment() {
    private var mRowsAdapter: ArrayObjectAdapter = ArrayObjectAdapter(ShadowRowPresenterSelector())

    private lateinit var videoBox: Box<Videos>
    private lateinit var contentBox: Box<Item>

    //lateinit var mBackgroundHelper: BackgroundHelper
    private val backgroundManager: BackgroundManager? by lazy {
        activity?.let {
            BackgroundManager.getInstance(
                it
            )
        }
    }

    companion object {
        private lateinit var homeRowFragment: HomeRowFragment
        fun homeRowFragmentInstance(): HomeRowFragment {
            homeRowFragment = HomeRowFragment()
            return homeRowFragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        contentBox = ObjectBox.boxStore.boxFor(Item::class.java)
        videoBox = ObjectBox.boxStore.boxFor(Videos::class.java)

        adapter = mRowsAdapter

        onItemViewSelectedListener =
            OnItemViewSelectedListener { itemViewHolder, item, rowViewHolder, row ->
                if (item != null) {
                    val currentItem = item as Item
                    val currentThumbanilUrl =
                        "https://i.ytimg.com/vi/" + currentItem.youtubeId + "/maxresdefault.jpg"
                    Glide.with(this)
                        .asBitmap()
                        .apply(bitmapTransform(BlurTransformation(25, 3)))
                        .load(currentThumbanilUrl)
                        .into(object : CustomTarget<Bitmap>() {
                            override fun onResourceReady(
                                resource: Bitmap,
                                transition: Transition<in Bitmap>?
                            ) {
                                backgroundManager?.setBitmap(resource)

                            }

                            override fun onLoadCleared(placeholder: Drawable?) {
                                // this is called when imageView is cleared on lifecycle call or for
                                // some other reason.
                                // if you are referencing the bitmap somewhere else too other than this imageView
                                // clear it here as you can no longer have the bitmap
                            }
                        })
                }
            }
        onItemViewClickedListener =
            OnItemViewClickedListener { itemViewHolder, item, rowViewHolder, row ->
                Toast.makeText(activity, "Implement click handler", Toast.LENGTH_SHORT)
                    .show()
            }
        createRows()
        mainFragmentAdapter.fragmentHost.notifyDataReady(mainFragmentAdapter)
        retainInstance = true


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun createRows() {
        contentBox.all
        for (row in videoBox.all.subList(1, videoBox.all.size - 1)) {
            mRowsAdapter.add(createCardRow(row))
        }
    }


    private fun createCardRow(cardRow: Videos): Row {
        val presenterSelector = activity?.baseContext?.let { CardPresenterSelector(it) }
        val adapter = ArrayObjectAdapter(presenterSelector)

        for (card in cardRow.contents) {
            val s3BucketandPath = S3Utils.getS3Model(card.snippet.thumb_image)
            val imageUrl =
                S3Utils.getPreSignedURL(s3BucketandPath.bucketPath, s3BucketandPath.filePath)
            card.thumbnails = imageUrl.toString()
            adapter.add(card)
        }

        val headerItem = HeaderItem(cardRow.title)
        return CardListRow(headerItem, adapter, cardRow)
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

}
