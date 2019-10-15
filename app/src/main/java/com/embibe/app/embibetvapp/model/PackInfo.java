
package com.embibe.app.embibetvapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PackInfo {

    @SerializedName("display_name")
    @Expose
    private String displayName;
    @SerializedName("feature_type")
    @Expose
    private String featureType;
    @SerializedName("pack_id")
    @Expose
    private Integer packId;
    @SerializedName("embiums_count")
    @Expose
    private Integer embiumsCount;
    @SerializedName("ui_element_id")
    @Expose
    private String uiElementId;

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getFeatureType() {
        return featureType;
    }

    public void setFeatureType(String featureType) {
        this.featureType = featureType;
    }

    public Integer getPackId() {
        return packId;
    }

    public void setPackId(Integer packId) {
        this.packId = packId;
    }

    public Integer getEmbiumsCount() {
        return embiumsCount;
    }

    public void setEmbiumsCount(Integer embiumsCount) {
        this.embiumsCount = embiumsCount;
    }

    public String getUiElementId() {
        return uiElementId;
    }

    public void setUiElementId(String uiElementId) {
        this.uiElementId = uiElementId;
    }


}
