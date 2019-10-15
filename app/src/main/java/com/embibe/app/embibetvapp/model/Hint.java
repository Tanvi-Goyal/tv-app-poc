package com.embibe.app.embibetvapp.model;

import com.google.gson.annotations.SerializedName;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class Hint {
    @Id(assignable = true)
    public long id;
    @SerializedName("display_order")
    private int displayOrder;

    @SerializedName("body")
    private String body;

    public Hint() {
    }

    public Hint(int displayOrder, String body) {
        this.displayOrder = displayOrder;
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(int displayOrder) {
        this.displayOrder = displayOrder;
    }
}
