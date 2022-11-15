
package com.au615584.urineanalyzerapp.Model.ObservationResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Type {

    @SerializedName("#text")
    @Expose
    private String text;
    @SerializedName("coding")
    @Expose
    private Coding coding;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Coding getCoding() {
        return coding;
    }

    public void setCoding(Coding coding) {
        this.coding = coding;
    }

}
