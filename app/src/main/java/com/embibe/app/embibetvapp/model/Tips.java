package com.embibe.app.embibetvapp.model;

import com.google.gson.annotations.SerializedName;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class Tips {
    @Id(assignable = true)
    public long id;

    @SerializedName("tips")
    public String tips;

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public Tips(String tips) {
        this.tips = tips;
    }
}
