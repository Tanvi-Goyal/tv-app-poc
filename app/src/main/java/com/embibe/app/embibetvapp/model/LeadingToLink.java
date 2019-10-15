
package com.embibe.app.embibetvapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LeadingToLink {

    @SerializedName("source")
    @Expose
    private String source;
    @SerializedName("target")
    @Expose
    private String target;
    @SerializedName("from")
    @Expose
    private String from;
    @SerializedName("to")
    @Expose
    private String to;
    @SerializedName("label")
    @Expose
    private Object label;
    @SerializedName("type")
    @Expose
    private Object type;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("seo_subject_name")
    @Expose
    private String seoSubjectName;
    @SerializedName("concept_url")
    @Expose
    private String conceptUrl;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Object getLabel() {
        return label;
    }

    public void setLabel(Object label) {
        this.label = label;
    }

    public Object getType() {
        return type;
    }

    public void setType(Object type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSeoSubjectName() {
        return seoSubjectName;
    }

    public void setSeoSubjectName(String seoSubjectName) {
        this.seoSubjectName = seoSubjectName;
    }

    public String getConceptUrl() {
        return conceptUrl;
    }

    public void setConceptUrl(String conceptUrl) {
        this.conceptUrl = conceptUrl;
    }

}
