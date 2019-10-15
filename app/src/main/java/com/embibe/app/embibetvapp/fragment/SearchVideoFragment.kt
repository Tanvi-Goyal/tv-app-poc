package com.embibe.app.embibetvapp.fragment

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.leanback.app.SearchSupportFragment
import androidx.leanback.widget.ArrayObjectAdapter
import androidx.leanback.widget.HeaderItem
import androidx.leanback.widget.ListRow
import androidx.leanback.widget.ObjectAdapter
import com.embibe.app.embibetvapp.awsUtils.S3Utils
import com.embibe.app.embibetvapp.model.Item
import com.embibe.app.embibetvapp.model.Item_
import com.embibe.app.embibetvapp.model.ObjectBox
import com.embibe.app.embibetvapp.model.Videos
import com.embibe.app.embibetvapp.presenter.CardPresenterSelector
import com.embibe.app.embibetvapp.presenter.ShadowRowPresenterSelector
import io.objectbox.Box


class SearchVideoFragment : SearchSupportFragment(), SearchSupportFragment.SearchResultProvider {

    private var mRowsAdapter: ArrayObjectAdapter = ArrayObjectAdapter(ShadowRowPresenterSelector())

    private lateinit var videoBox: Box<Videos>
    private lateinit var contentBox: Box<Item>

    private val mResultsFound = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        contentBox = ObjectBox.boxStore.boxFor(Item::class.java)
        videoBox = ObjectBox.boxStore.boxFor(Videos::class.java)
        title = "Search"
        setSearchResultProvider(this)
        //  createRows()
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        var newQuery = query

        if (!TextUtils.isEmpty(newQuery) && newQuery != "nil") {
            //getActivity().findViewById(R.id.search_progressbar).setVisibility(View.VISIBLE)
            newQuery = "%$newQuery%"
            //mViewModel.setQueryMessage(newQuery);
            Log.d("onQueryTextChange", newQuery)
            if (query != null)
                createCardRow(query)
        }
        return true
    }


    private fun createCardRow(query: String) {
        val presenterSelector = activity?.baseContext?.let { CardPresenterSelector(it) }
        val adapter = ArrayObjectAdapter(presenterSelector)
        val header = HeaderItem("Search result for $query")
        val queriedList = contentBox.query().contains(Item_.title, query).build().find().toList()
        if (queriedList.isNotEmpty()) {
            for (card in queriedList) {
                val s3BucketandPath = S3Utils.getS3Model(card.snippet.thumb_image)
                val imageUrl = S3Utils.getPreSignedURL(s3BucketandPath.bucketPath, s3BucketandPath.filePath)
                card.thumbnails = imageUrl.toString()
                adapter.add(card)
            }
        }
        mRowsAdapter.clear()
        val row = ListRow(header, adapter)
        mRowsAdapter.add(row)
    }


    override fun getResultsAdapter(): ObjectAdapter {
        return mRowsAdapter
    }

    override fun onQueryTextChange(query: String?): Boolean {
        var newQuery = query

        if (!TextUtils.isEmpty(newQuery) && newQuery != "nil") {
            // activity?.findViewById(R.id.search_progressbar).setVisibility(View.VISIBLE)
            newQuery = "%$newQuery%"
            //mViewModel.setQueryMessage(newQuery);
            Log.d("onQueryTextChange", newQuery)
            if (query != null)
                createCardRow(query)
        }
        return true
    }

    fun hasResults(): Boolean {
        return mRowsAdapter.size() > 0 && mResultsFound
    }

    fun focusOnSearch() {
        // Objects.requireNonNull(getView()).findViewById(R.id.lb_search_bar).requestFocus()
    }
}