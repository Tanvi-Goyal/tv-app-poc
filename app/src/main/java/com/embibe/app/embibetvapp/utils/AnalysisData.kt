package com.embibe.app.embibetvapp.utils

import com.embibe.app.embibetvapp.model.Analysis
import com.github.mikephil.charting.data.BarEntry

class AnalysisData {

    fun getOverAllData(): Analysis {
        var overAllData = Analysis
        overAllData.overAllYouValue = 65
        overAllData.overAllCutOffValue = 75
        overAllData.overAllSocialValue = 55

        overAllData.timeSpentYouValue = 10
        overAllData.timeSpentRankerValue = 30
        overAllData.timeSpentSocialValue = 43

        overAllData.videoWatchedYouValue = 35
        overAllData.videoWatchedRankerValue = 45
        overAllData.videoWatchedSocialValue = 55

        overAllData.behaviorYouValue = 65
        overAllData.behaviorRankerValue = 55
        overAllData.behaviorSocialValue = 40

        overAllData.activitySummarySubtitle =
            "You're doing great! you spent <font color='#0000'><b>7 hours</b></font> learning this week"
        overAllData.activitySummaryTimeSpent = 7
        overAllData.activitySummaryTestTaken = "16"
        overAllData.activitySummaryTotalTest = "48"
        overAllData.activitySummaryQuestionPractised = 243
        overAllData.activitySummaryVideoWatched = "35"
        overAllData.activitySummaryTotalVideos = "48"

        val labels = ArrayList<String>()
        labels.add("Mon")
        labels.add("Tue")
        labels.add("Wed")
        labels.add("Thu")
        labels.add("Fri")
        labels.add("Sat")
        labels.add("Sun")
        overAllData.labels.addAll(labels)

        val entries: ArrayList<BarEntry> = ArrayList()
        entries.add(BarEntry(0f, 14f))
        entries.add(BarEntry(1f, 38f))
        entries.add(BarEntry(2f, 66f))
        entries.add(BarEntry(3f, 70f))
        entries.add(BarEntry(4f, 80f))
        entries.add(BarEntry(5f, 20f))
        entries.add(BarEntry(6f, 40f))
        overAllData.arrayBarEntity.addAll(entries)
        return overAllData
    }
}