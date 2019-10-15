
package com.embibe.app.embibetvapp.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AvailableTests {

    @SerializedName("part-test")
    @Expose
    private List<PartTest> partTest = null;

    public List<PartTest> getPartTest() {
        return partTest;
    }

    public void setPartTest(List<PartTest> partTest) {
        this.partTest = partTest;
    }

}
