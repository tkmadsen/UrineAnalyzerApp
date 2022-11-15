
package com.au615584.urineanalyzerapp.Model.ObservationResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Meta {

    @SerializedName("#text")
    @Expose
    private String text;
    @SerializedName("versionId")
    @Expose
    private String versionId;
    @SerializedName("lastUpdated")
    @Expose
    private String lastUpdated;
    @SerializedName("profile")
    @Expose
    private String profile;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getVersionId() {
        return versionId;
    }

    public void setVersionId(String versionId) {
        this.versionId = versionId;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

}
