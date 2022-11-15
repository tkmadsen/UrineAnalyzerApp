
package com.au615584.urineanalyzerapp.Model.ObservationResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Code__1 {

    @SerializedName("#text")
    @Expose
    private String text;
    @SerializedName("coding")
    @Expose
    private Coding__2 coding;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Coding__2 getCoding() {
        return coding;
    }

    public void setCoding(Coding__2 coding) {
        this.coding = coding;
    }

}
