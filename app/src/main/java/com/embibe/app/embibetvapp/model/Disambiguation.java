
package com.embibe.app.embibetvapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Disambiguation {

    @SerializedName("autofill")
    @Expose
    private String autofill;
    @SerializedName("is_disambiguated")
    @Expose
    private Boolean isDisambiguated;
    @SerializedName("top_result")
    @Expose
    private TopResult topResult;

    public String getAutofill() {
        return autofill;
    }

    public void setAutofill(String autofill) {
        this.autofill = autofill;
    }

    public Boolean getIsDisambiguated() {
        return isDisambiguated;
    }

    public void setIsDisambiguated(Boolean isDisambiguated) {
        this.isDisambiguated = isDisambiguated;
    }

    public TopResult getTopResult() {
        return topResult;
    }

    public void setTopResult(TopResult topResult) {
        this.topResult = topResult;
    }


}
