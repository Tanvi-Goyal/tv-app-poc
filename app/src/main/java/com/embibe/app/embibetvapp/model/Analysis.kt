package com.embibe.app.embibetvapp.model

import com.github.mikephil.charting.data.BarEntry

object Analysis {
    var overAllYouValue: Int = 0
    var overAllCutOffValue: Int = 0
    var overAllSocialValue: Int = 0
    var timeSpentYouValue: Int = 0
    var timeSpentRankerValue: Int = 0
    var timeSpentSocialValue: Int = 0
    var videoWatchedYouValue: Int = 0
    var videoWatchedRankerValue: Int = 0
    var videoWatchedSocialValue: Int = 0
    var behaviorYouValue: Int = 0
    var behaviorYouValueString: String = "In Control"
    var behaviorRankerValue: Int = 0
    var behaviorRankerString: String = "In Control"
    var behaviorSocialValue: Int = 0
    var behaviorSocialString: String = "Flukes"
    var activitySummarySubtitle: String = ""
    var activitySummaryTimeSpent: Int = 0
    var activitySummaryTestTaken: String = ""
    var activitySummaryTotalTest: String = ""
    var activitySummaryQuestionPractised: Int = 0
    var activitySummaryVideoWatched: String = ""
    var activitySummaryTotalVideos: String = ""
    var arrayBarEntity: ArrayList<BarEntry> = ArrayList()
    val labels = ArrayList<String>()
}