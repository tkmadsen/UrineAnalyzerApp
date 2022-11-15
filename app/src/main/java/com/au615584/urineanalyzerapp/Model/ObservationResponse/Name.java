
package com.au615584.urineanalyzerapp.Model.ObservationResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Name {

    @SerializedName("#text")
    @Expose
    private String text;
    @SerializedName("family")
    @Expose
    private String family;
    @SerializedName("given")
    @Expose
    private String given;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getGiven() {
        return given;
    }

    public void setGiven(String given) {
        this.given = given;
    }

}
