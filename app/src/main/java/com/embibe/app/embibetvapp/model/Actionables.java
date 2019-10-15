
package com.embibe.app.embibetvapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Actionables {

    @SerializedName("imp-que")
    @Expose
    private ImpQue impQue;
    @SerializedName("top-prev-year-que")
    @Expose
    private Object topPrevYearQue;
    @SerializedName("que-rankers-wrong")
    @Expose
    private QueRankersWrong queRankersWrong;

    public ImpQue getImpQue() {
        return impQue;
    }

    public void setImpQue(ImpQue impQue) {
        this.impQue = impQue;
    }

    public Object getTopPrevYearQue() {
        return topPrevYearQue;
    }

    public void setTopPrevYearQue(Object topPrevYearQue) {
        this.topPrevYearQue = topPrevYearQue;
    }

    public QueRankersWrong getQueRankersWrong() {
        return queRankersWrong;
    }

    public void setQueRankersWrong(QueRankersWrong queRankersWrong) {
        this.queRankersWrong = queRankersWrong;
    }

}
