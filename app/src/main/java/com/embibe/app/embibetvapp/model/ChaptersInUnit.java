
package com.embibe.app.embibetvapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ChaptersInUnit {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("seo_subject_name")
    @Expose
    private String seoSubjectName;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("practice_url")
    @Expose
    private String practiceUrl;
    @SerializedName("learning_map")
    @Expose
    private LearningMap learningMap;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeoSubjectName() {
        return seoSubjectName;
    }

    public void setSeoSubjectName(String seoSubjectName) {
        this.seoSubjectName = seoSubjectName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPracticeUrl() {
        return practiceUrl;
    }

    public void setPracticeUrl(String practiceUrl) {
        this.practiceUrl = practiceUrl;
    }

    public LearningMap getLearningMap() {
        return learningMap;
    }

    public void setLearningMap(LearningMap learningMap) {
        this.learningMap = learningMap;
    }

}
