
package com.embibe.app.embibetvapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Lmap {

    @SerializedName("ch")
    @Expose
    private String ch;
    @SerializedName("cn")
    @Expose
    private String cn;
    @SerializedName("ex")
    @Expose
    private String ex;
    @SerializedName("gl")
    @Expose
    private String gl;
    @SerializedName("qn")
    @Expose
    private Object qn;
    @SerializedName("sb")
    @Expose
    private String sb;
    @SerializedName("un")
    @Expose
    private String un;

    public String getCh() {
        return ch;
    }

    public void setCh(String ch) {
        this.ch = ch;
    }

    public String getCn() {
        return cn;
    }

    public void setCn(String cn) {
        this.cn = cn;
    }

    public String getEx() {
        return ex;
    }

    public void setEx(String ex) {
        this.ex = ex;
    }

    public String getGl() {
        return gl;
    }

    public void setGl(String gl) {
        this.gl = gl;
    }

    public Object getQn() {
        return qn;
    }

    public void setQn(Object qn) {
        this.qn = qn;
    }

    public String getSb() {
        return sb;
    }

    public void setSb(String sb) {
        this.sb = sb;
    }

    public String getUn() {
        return un;
    }

    public void setUn(String un) {
        this.un = un;
    }


}
