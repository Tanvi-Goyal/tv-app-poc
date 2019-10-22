package com.embibe.app.embibetvapp.presenter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.leanback.widget.BaseCardView
import com.embibe.app.embibetvapp.R
import com.embibe.app.embibetvapp.model.Analysis
import com.embibe.app.embibetvapp.utils.AnalysisData
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter

class ChartPresenter(context: Context) : AbstractCardPresenter<BaseCardView>(context) {

    private var analysisData = AnalysisData()

    override fun onCreateView(): BaseCardView {
        val cardView = BaseCardView(
            context, null
        )
        cardView.addView(LayoutInflater.from(context).inflate(R.layout.item_chart, null))
        return cardView
    }

    override fun onBindViewHolder(card: Any, cardView: BaseCardView) {
        val chart = cardView.findViewById<BarChart>(R.id.last_seven_days_chart)
        val spinner = cardView.findViewById<Spinner>(R.id.spinner)

        loadChart(analysisData.getOverAllData(), chart)

        val adapter = ArrayAdapter.createFromResource(
            cardView.context, R.array.days_array, R.layout.spinner_item
        )
        spinner.adapter = adapter
    }

    private fun loadChart(
        analysis: Analysis,
        lastSevenDaysChart: BarChart
    ) {

        lastSevenDaysChart.clear()
        lastSevenDaysChart.invalidate()
        lastSevenDaysChart.clear()

        val entries: ArrayList<BarEntry> = ArrayList()
        entries.addAll(analysis.arrayBarEntity)
        val dataset = BarDataSet(entries, "")
        dataset.setDrawValues(false)
        dataset.color = Color.rgb(30, 138, 228)

        val data = BarData(dataset)
        data.barWidth = 0.6f
        lastSevenDaysChart.data = data
        lastSevenDaysChart.legend.isEnabled = false
        lastSevenDaysChart.xAxis.isEnabled = true // x-axis
        lastSevenDaysChart.xAxis.textColor = Color.rgb(159, 160, 161)
        lastSevenDaysChart.xAxis.textSize = 14f
        lastSevenDaysChart.xAxis.setDrawGridLines(false) // disabling horizontal background grid lines
        lastSevenDaysChart.xAxis.position = XAxis.XAxisPosition.BOTTOM
        lastSevenDaysChart.xAxis.valueFormatter = IndexAxisValueFormatter(analysis.labels)
        lastSevenDaysChart.xAxis.labelCount = analysis.labels.size
        lastSevenDaysChart.xAxis.textColor = Color.BLACK
        lastSevenDaysChart.setExtraOffsets(5f, 5f, 5f, 5f)

        lastSevenDaysChart.axisLeft.isEnabled = true // y-axis
        lastSevenDaysChart.axisLeft.textSize = 14f
        lastSevenDaysChart.axisLeft.setDrawGridLines(true) // disabling vertical background grid lines
        lastSevenDaysChart.axisLeft.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART)
        lastSevenDaysChart.axisLeft.textColor = Color.rgb(159, 160, 161)
        lastSevenDaysChart.axisLeft.axisMaximum = 100f
        lastSevenDaysChart.axisLeft.axisMinimum = 0f

        lastSevenDaysChart.axisRight.isEnabled = false

        val description = Description()
        description.text = ""
        lastSevenDaysChart.description = description
        lastSevenDaysChart.setPinchZoom(false)
        lastSevenDaysChart.setTouchEnabled(false)
        analysis.labels.clear()
        analysis.arrayBarEntity.clear()
    }
}
