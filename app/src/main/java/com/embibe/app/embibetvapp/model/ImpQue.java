
package com.embibe.app.embibetvapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ImpQue {

    @SerializedName("question_code")
    @Expose
    private String questionCode;
    @SerializedName("question_text")
    @Expose
    private String questionText;
    @SerializedName("practice_url")
    @Expose
    private String practiceUrl;
    @SerializedName("widget_name")
    @Expose
    private String widgetName;

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

    public String getWidgetName() {
        return widgetName;
    }

    public void setWidgetName(String widgetName) {
        this.widgetName = widgetName;
    }


}
