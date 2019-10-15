package com.embibe.app.embibetvapp.fragment


import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import androidx.leanback.app.BackgroundManager
import androidx.leanback.app.BrowseSupportFragment
import androidx.leanback.widget.*
import com.embibe.app.embibetvapp.R
import com.embibe.app.embibetvapp.activity.SearchActivity

/**
 * A simple [Fragment] subclass.
 */
public class DashBoardFragment : BrowseSupportFragment() {

    private lateinit var mRowsAdapter: ArrayObjectAdapter

    companion object {
        private val HEADER_ID_1: Long = 1
        private val HEADER_NAME_1 = "HOME"
        private val HEADER_ID_2: Long = 2
        private val HEADER_NAME_2 = "ANALYSIS"
        private val HEADER_ID_3: Long = 3
        private val HEADER_NAME_3 = "PROFILE"
        private val HEADER_ID_4: Long = 4
        private val HEADER_NAME_4 = "SETTING"

    }


    private lateinit var mBackgroundManager: BackgroundManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupUi()
        loadData()
        mBackgroundManager = BackgroundManager.getInstance(activity!!)
        mBackgroundManager.attach(activity!!.window)
        mainFragmentRegistry.registerFragment(
            PageRow::class.java,
            PageRowFragmentFactory(mBackgroundManager)
        )

    }

    private fun setupUi() {
        headersState = HEADERS_ENABLED
        isHeadersTransitionOnBackEnabled = true
        brandColor = resources.getColor(R.color.fastlane_background)
        title = "EmbibeTV"
        setOnSearchClickedListener {
            /*Toast.makeText(
                activity, getString(R.string.implement_search), Toast.LENGTH_SHORT
            ).show()*/
            val intent = Intent(activity, SearchActivity::class.java)
            startActivity(intent)
        }
        //loader before child fragment is added
        prepareEntranceTransition()
    }

    private fun loadData() {
        mRowsAdapter = ArrayObjectAdapter(ListRowPresenter())
        adapter = mRowsAdapter

        Handler().postDelayed({
            createRows()
            startEntranceTransition()
        }, 2000)
    }

    private fun createRows() {
        val headerItem1 = HeaderItem(HEADER_ID_1, HEADER_NAME_1)
        val pageRow1 = PageRow(headerItem1)
        mRowsAdapter.add(pageRow1)

        val headerItem2 = HeaderItem(HEADER_ID_2, HEADER_NAME_2)
        val pageRow2 = PageRow(headerItem2)
        mRowsAdapter.add(pageRow2)

        val headerItem3 = HeaderItem(HEADER_ID_3, HEADER_NAME_3)
        val pageRow3 = PageRow(headerItem3)
        mRowsAdapter.add(pageRow3)

        val headerItem4 = HeaderItem(HEADER_ID_4, HEADER_NAME_4)
        val pageRow4 = PageRow(headerItem4)
        mRowsAdapter.add(pageRow4)
    }


    inner class PageRowFragmentFactory internal constructor(private val mBackgroundManager: BackgroundManager) :
        FragmentFactory<Fragment>() {

        override fun createFragment(rowObj: Any): Fragment {
            val row = rowObj as Row
            mBackgroundManager.drawable = null
            return when {
                row.headerItem.id == HEADER_ID_1 -> HomeRowFragment.homeRowFragmentInstance()
                row.headerItem.id == HEADER_ID_2 -> AnalysisFragment()
                row.headerItem.id == HEADER_ID_3 -> AnalysisFragment()
                row.headerItem.id == HEADER_ID_4 -> AnalysisFragment()
                else -> throw IllegalArgumentException(String.format("Invalid row %s", rowObj))
            }

        }
    }

}
