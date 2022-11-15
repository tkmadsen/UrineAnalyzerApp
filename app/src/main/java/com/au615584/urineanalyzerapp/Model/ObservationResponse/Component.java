
package com.au615584.urineanalyzerapp.Model.ObservationResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Component {

    @SerializedName("#text")
    @Expose
    private String text;
    @SerializedName("extension")
    @Expose
    private Extension__2 extension;
    @SerializedName("code")
    @Expose
    private Code__2 code;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Extension__2 getExtension() {
        return extension;
    }

    public void setExtension(Extension__2 extension) {
        this.extension = extension;
    }

    public Code__2 getCode() {
        return code;
    }

    public void setCode(Code__2 code) {
        this.code = code;
    }

}
