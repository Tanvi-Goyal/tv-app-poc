
package com.embibe.app.embibetvapp.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Relation {

    @SerializedName("derived_from_links")
    @Expose
    private List<Object> derivedFromLinks = null;
    @SerializedName("leading_to_links")
    @Expose
    private List<LeadingToLink> leadingToLinks = null;
    @SerializedName("root_kt_node")
    @Expose
    private List<RootKtNode> rootKtNode = null;

    public List<Object> getDerivedFromLinks() {
        return derivedFromLinks;
    }

    public void setDerivedFromLinks(List<Object> derivedFromLinks) {
        this.derivedFromLinks = derivedFromLinks;
    }

    public List<LeadingToLink> getLeadingToLinks() {
        return leadingToLinks;
    }

    public void setLeadingToLinks(List<LeadingToLink> leadingToLinks) {
        this.leadingToLinks = leadingToLinks;
    }

    public List<RootKtNode> getRootKtNode() {
        return rootKtNode;
    }

    public void setRootKtNode(List<RootKtNode> rootKtNode) {
        this.rootKtNode = rootKtNode;
    }

}
