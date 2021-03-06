
package com.embibe.app.embibetvapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class QuestionsRankersGotWrong {

    @SerializedName("question_code")
    @Expose
    private String questionCode;
    @SerializedName("question_text")
    @Expose
    private String questionText;
    @SerializedName("practice_url")
    @Expose
    private String practiceUrl;
    @SerializedName("ranker_info")
    @Expose
    private RankerInfo rankerInfo;

    public String getQuestionCode() {
        return questionCode;
    }

    public void setQuestionCode(String questionCode) {
        this.questionCode = questionCode;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getPracticeUrl() {
        return practiceUrl;
    }

    public void setPracticeUrl(String practiceUrl) {
        this.practiceUrl = practiceUrl;
    }

    public RankerInfo getRankerInfo() {
        return rankerInfo;
    }

    public void setRankerInfo(RankerInfo rankerInfo) {
        this.rankerInfo = rankerInfo;
    }

}
