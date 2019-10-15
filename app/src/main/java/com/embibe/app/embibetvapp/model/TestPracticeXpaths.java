
package com.embibe.app.embibetvapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TestPracticeXpaths {

    @SerializedName("test_xpaths")
    @Expose
    private TestXpaths testXpaths;
    @SerializedName("practice_xpaths")
    @Expose
    private PracticeXpaths practiceXpaths;

    public TestXpaths getTestXpaths() {
        return testXpaths;
    }

    public void setTestXpaths(TestXpaths testXpaths) {
        this.testXpaths = testXpaths;
    }

    public PracticeXpaths getPracticeXpaths() {
        return practiceXpaths;
    }

    public void setPracticeXpaths(PracticeXpaths practiceXpaths) {
        this.practiceXpaths = practiceXpaths;
    }


}
