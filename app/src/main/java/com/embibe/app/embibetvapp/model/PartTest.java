
package com.embibe.app.embibetvapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PartTest {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("no_of_question")
    @Expose
    private Integer noOfQuestion;
    @SerializedName("minutes")
    @Expose
    private Integer minutes;
    @SerializedName("xpath")
    @Expose
    private String xpath;
    @SerializedName("path")
    @Expose
    private String path;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNoOfQuestion() {
        return noOfQuestion;
    }

    public void setNoOfQuestion(Integer noOfQuestion) {
        this.noOfQuestion = noOfQuestion;
    }

    public Integer getMinutes() {
        return minutes;
    }

    public void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }

    public String getXpath() {
        return xpath;
    }

    public void setXpath(String xpath) {
        this.xpath = xpath;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

}
