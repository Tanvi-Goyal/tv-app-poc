package com.embibe.app.embibetvapp.fragment


import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.leanback.app.RowsSupportFragment
import androidx.leanback.widget.ArrayObjectAdapter
import androidx.leanback.widget.HeaderItem
import androidx.leanback.widget.OnItemViewClickedListener
import androidx.leanback.widget.Row
import com.embibe.app.embibetvapp.R
import com.embibe.app.embibetvapp.databinding.FragmentAnalysisBinding
import com.embibe.app.embibetvapp.model.CardRow
import com.embibe.app.embibetvapp.presenter.CardPresenterSelector
import com.embibe.app.embibetvapp.presenter.ShadowRowPresenterSelector
import com.embibe.app.embibetvapp.utils.CardListRow
import com.embibe.app.embibetvapp.utils.Utils
import com.google.gson.Gson

/**
 * A simple [Fragment] subclass.
 */
class AnalysisFragment : RowsSupportFragment() {
    private lateinit var fragmentAnalysisBinding: FragmentAnalysisBinding
    private var mRowsAdapter: ArrayObjectAdapter =
        ArrayObjectAdapter(ShadowRowPresenterSelector())

    init {
        adapter = mRowsAdapter
        onItemViewClickedListener =
            OnItemViewClickedListener { itemViewHolder, item, rowViewHolder, row ->
                Toast.makeText(activity, "Implement click handler", Toast.LENGTH_SHORT)
                    .show()
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        createRows()
        mainFragmentAdapter.fragmentHost.notifyDataReady(mainFragmentAdapter)
    }

    private fun createRows() {
        val json = Utils.inputStreamToString(
            resources.openRawResource(
                R.raw.analysis
            )
        )
        val rows = Gson().fromJson(json, Array<CardRow>::class.java)
        for (row in rows) {
            if (row.type === CardRow.TYPE_DEFAULT) {
                mRowsAdapter.add(createCardRow(row))
            }
        }
    }

    private fun createCardRow(cardRow: CardRow): Row {
        val presenterSelector = activity?.let { CardPresenterSelector(it) }
        val adapter = ArrayObjectAdapter(presenterSelector)
        for (card in cardRow.cards!!) {
            adapter.add(card)
        }

        val headerItem = HeaderItem(cardRow.title)
        return CardListRow(headerItem, adapter, cardRow)
    }

}
