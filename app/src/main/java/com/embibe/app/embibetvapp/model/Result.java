
package com.embibe.app.embibetvapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("desc")
    @Expose
    private String desc;
    @SerializedName("final_score")
    @Expose
    private Double finalScore;
    @SerializedName("index")
    @Expose
    private String index;
    @SerializedName("is_visible")
    @Expose
    private Boolean isVisible;
    @SerializedName("learn_path")
    @Expose
    private String learnPath;
    @SerializedName("lmap")
    @Expose
    private Lmap lmap;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("old_id")
    @Expose
    private Integer oldId;
    @SerializedName("recommended")
    @Expose
    private Boolean recommended;
    @SerializedName("seo_subject_name")
    @Expose
    private String seoSubjectName;
    @SerializedName("valid_exams")
    @Expose
    private String validExams;
    @SerializedName("valid_goals")
    @Expose
    private String validGoals;
    @SerializedName("widget")
    @Expose
    private String widget;
    @SerializedName("widget_id")
    @Expose
    private String widgetId;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("actionables")
    @Expose
    private Actionables actionables;
    @SerializedName("wiki_friendly_name")
    @Expose
    private String wikiFriendlyName;
    @SerializedName("pack_info")
    @Expose
    private PackInfo packInfo;
    @SerializedName("goal_code")
    @Expose
    private Object goalCode;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Double getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(Double finalScore) {
        this.finalScore = finalScore;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public Boolean getIsVisible() {
        return isVisible;
    }

    public void setIsVisible(Boolean isVisible) {
        this.isVisible = isVisible;
    }

    public String getLearnPath() {
        return learnPath;
    }

    public void setLearnPath(String learnPath) {
        this.learnPath = learnPath;
    }

    public Lmap getLmap() {
        return lmap;
    }

    public void setLmap(Lmap lmap) {
        this.lmap = lmap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOldId() {
        return oldId;
    }

    public void setOldId(Integer oldId) {
        this.oldId = oldId;
    }

    public Boolean getRecommended() {
        return recommended;
    }

    public void setRecommended(Boolean recommended) {
        this.recommended = recommended;
    }

    public String getSeoSubjectName() {
        return seoSubjectName;
    }

    public void setSeoSubjectName(String seoSubjectName) {
        this.seoSubjectName = seoSubjectName;
    }

    public String getValidExams() {
        return validExams;
    }

    public void setValidExams(String validExams) {
        this.validExams = validExams;
    }

    public String getValidGoals() {
        return validGoals;
    }

    public void setValidGoals(String validGoals) {
        this.validGoals = validGoals;
    }

    public String getWidget() {
        return widget;
    }

    public void setWidget(String widget) {
        this.widget = widget;
    }

    public String getWidgetId() {
        return widgetId;
    }

    public void setWidgetId(String widgetId) {
        this.widgetId = widgetId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Actionables getActionables() {
        return actionables;
    }

    public void setActionables(Actionables actionables) {
        this.actionables = actionables;
    }

    public String getWikiFriendlyName() {
        return wikiFriendlyName;
    }

    public void setWikiFriendlyName(String wikiFriendlyName) {
        this.wikiFriendlyName = wikiFriendlyName;
    }

    public PackInfo getPackInfo() {
        return packInfo;
    }

    public void setPackInfo(PackInfo packInfo) {
        this.packInfo = packInfo;
    }

    public Object getGoalCode() {
        return goalCode;
    }

    public void setGoalCode(Object goalCode) {
        this.goalCode = goalCode;
    }

}
