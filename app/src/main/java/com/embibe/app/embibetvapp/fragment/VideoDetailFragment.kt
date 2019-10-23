package com.embibe.app.embibetvapp.fragment


import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.leanback.app.BackgroundManager
import androidx.leanback.app.DetailsSupportFragment
import androidx.leanback.widget.*
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.transition.Transition
import com.embibe.app.embibetvapp.R
import com.embibe.app.embibetvapp.activity.VideoDetailActivity
import com.embibe.app.embibetvapp.activity.VideoDetailActivity.Companion.SHARED_ELEMENT_NAME
import com.embibe.app.embibetvapp.awsUtils.S3Utils
import com.embibe.app.embibetvapp.model.Item
import com.embibe.app.embibetvapp.model.ObjectBox
import com.embibe.app.embibetvapp.model.Videos
import com.embibe.app.embibetvapp.presenter.CardPresenterSelector
import com.embibe.app.embibetvapp.presenter.DetailsDescriptionPresenter
import com.embibe.app.embibetvapp.utils.CardListRow
import io.objectbox.Box

/**
 * A simple [Fragment] subclass.
 */
class VideoDetailFragment : DetailsSupportFragment() {

    private lateinit var mHelper: FullWidthDetailsOverviewSharedElementHelper

    private lateinit var mAdapter: ArrayObjectAdapter

    private lateinit var mPresenterSelector: ClassPresenterSelector


    private lateinit var selectedItem: Item

    private lateinit var mBackgroundManager: BackgroundManager

    private lateinit var mDefaultBackground: Drawable

    private lateinit var mMetrics: DisplayMetrics


    companion object {
        private var contentBox: Box<Item> = ObjectBox.boxStore.boxFor(Item::class.java)
        private var videoBox: Box<Videos> = ObjectBox.boxStore.boxFor(Videos::class.java)

        private const val ACTION_PLAY = 1
        private const val ACTION_FAVOURITE = 2
        private const val ACTION_RELATED = 3
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        prepareBackgroundManager()

        if (activity!!.intent.getLongExtra(
                VideoDetailActivity.ITEM_ID,
                10000000000000
            ) != 10000000000000
        ) {
            selectedItem = contentBox.get(
                activity!!.intent.getLongExtra(
                    VideoDetailActivity.ITEM_ID,
                    0
                )
            )

           // updateBackground("https://i.ytimg.com/vi/" + selectedItem.youtubeId + "/maxresdefault.jpg")
        }



        setupAdapter()
        setupDetailsOverviewRow()
        setupRelatedListRow()

    }

    private fun setupRelatedListRow() {
        mAdapter.add(createCardRow(videoBox.all[5]))
    }

    override fun onResume() {
        super.onResume()
        updateBackground("https://i.ytimg.com/vi/" + selectedItem.youtubeId + "/maxresdefault.jpg")
    }


    private fun setupAdapter() {
        // Set detail background and style.
        val detailsPresenter = FullWidthDetailsOverviewRowPresenter(
            DetailsDescriptionPresenter(),
            MovieDetailsOverviewLogoPresenter()
        )

        detailsPresenter.backgroundColor =
            ContextCompat.getColor(activity!!, R.color.selected_background)
        detailsPresenter.initialState = FullWidthDetailsOverviewRowPresenter.STATE_HALF

        // Hook up transition element.
        mHelper = FullWidthDetailsOverviewSharedElementHelper()
        mHelper.setSharedElementEnterTransition(activity, SHARED_ELEMENT_NAME)
        detailsPresenter.setListener(mHelper)
        detailsPresenter.isParticipatingEntranceTransition = false
        prepareEntranceTransition()

        detailsPresenter.setOnActionClickedListener { action ->
            when {
                action.id == ACTION_PLAY.toLong() -> {
                    /* val intent = Intent(activity, PlaybackActivity::class.java)
                         intent.putExtra(VideoDetailsActivity.VIDEO, mSelectedVideo)
                         startActivity(intent)*/
                }
                action.id == ACTION_FAVOURITE.toLong() -> Toast.makeText(activity, "ADDED TO FAVOURITES", Toast.LENGTH_SHORT).show()
                else -> setSelectedPosition(2)
            }
        }

        mPresenterSelector = ClassPresenterSelector()
        mPresenterSelector.addClassPresenter(DetailsOverviewRow::class.java, detailsPresenter)
        mPresenterSelector.addClassPresenter(ListRow::class.java, ListRowPresenter())
        mAdapter = ArrayObjectAdapter(mPresenterSelector)
        adapter = mAdapter
    }


    private fun setupDetailsOverviewRow() {
        val row = DetailsOverviewRow(selectedItem)

        val options = RequestOptions()
            .error(R.drawable.default_background)
            .dontAnimate()

        val s3BucketandPath = S3Utils.getS3Model(selectedItem.snippet.thumb_image)
        val imageUrl =
            S3Utils.getPreSignedURL(s3BucketandPath.bucketPath, s3BucketandPath.filePath)

        Glide.with(activity!!)
            .asBitmap()
            .load(imageUrl)
            .apply(options)
            .into(object : SimpleTarget<Bitmap>() {
                override fun onResourceReady(
                    resource: Bitmap,
                    transition: Transition<in Bitmap>?
                ) {
                    row.setImageBitmap(activity!!, resource)
                    startEntranceTransition()
                }
            })

        val adapter = SparseArrayObjectAdapter()

        adapter.set(
            ACTION_PLAY, Action(
                ACTION_PLAY.toLong(), resources
                    .getString(R.string.play),
                resources.getString(R.string.video)
            )
        )
        adapter.set(
            ACTION_FAVOURITE, Action(
                ACTION_FAVOURITE.toLong(), resources.getString(R.string.add_to),
                resources.getString(R.string.favourite)
            )
        )
        adapter.set(
            ACTION_RELATED, Action(
                ACTION_RELATED.toLong(), resources.getString(R.string.related),
                resources.getString(R.string.videos)
            )
        )
        row.actionsAdapter = adapter

        mAdapter.add(row)
    }

    private fun prepareBackgroundManager() {
        mBackgroundManager = BackgroundManager.getInstance(activity!!)
        mBackgroundManager.attach(activity!!.window)
        mDefaultBackground = resources.getDrawable(R.drawable.default_background, null)
        mMetrics = DisplayMetrics()
        activity!!.windowManager.defaultDisplay.getMetrics(mMetrics)
    }

    internal class MovieDetailsOverviewLogoPresenter : DetailsOverviewLogoPresenter() {

        internal class ViewHolder(view: View) : DetailsOverviewLogoPresenter.ViewHolder(view) {

            override fun getParentPresenter(): FullWidthDetailsOverviewRowPresenter {
                return mParentPresenter
            }

            override fun getParentViewHolder(): FullWidthDetailsOverviewRowPresenter.ViewHolder {
                return mParentViewHolder
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup): Presenter.ViewHolder {
            val imageView = LayoutInflater.from(parent.context)
                .inflate(R.layout.lb_fullwidth_details_overview_logo, parent, false) as ImageView

            val res = parent.resources
            val width = res.getDimensionPixelSize(R.dimen.movie_image_card_width)
            val height = res.getDimensionPixelSize(R.dimen.movie_image_card_height)
            imageView.layoutParams = ViewGroup.MarginLayoutParams(width, height)
            //imageView.scaleType = ImageView.ScaleType.CENTER_CROP

            return ViewHolder(imageView)
        }

        override fun onBindViewHolder(viewHolder: Presenter.ViewHolder, item: Any) {
            val row = item as DetailsOverviewRow
            val imageView = viewHolder.view as ImageView
            imageView.setImageDrawable(row.imageDrawable)
            if (isBoundToImage(viewHolder as ViewHolder, row)) {
                viewHolder.parentPresenter.notifyOnBindLogo(viewHolder.parentViewHolder)
            }
        }
    }


    private fun updateBackground(uri: String) {
        val options = RequestOptions()
            .override(mMetrics.widthPixels, mMetrics.heightPixels)
            .centerCrop()
            .error(mDefaultBackground)

        Glide.with(activity!!)
            .asBitmap()
            .load(uri)
            .apply(options)
            .into(object : SimpleTarget<Bitmap>() {
                override fun onResourceReady(
                    resource: Bitmap,
                    transition: Transition<in Bitmap>?
                ) {
                    mBackgroundManager.setBitmap(resource)
                }
            })

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

        val headerItem = HeaderItem("RELATED VIDEOS")
        return CardListRow(headerItem, adapter, cardRow)
    }


}
