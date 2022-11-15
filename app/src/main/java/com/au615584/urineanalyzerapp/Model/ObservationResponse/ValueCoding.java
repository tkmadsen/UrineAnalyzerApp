
package com.au615584.urineanalyzerapp.Model.ObservationResponse;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ValueCoding {

    @SerializedName("#text")
    @Expose
    private String text;
    @SerializedName("system")
    @Expose
    private String system;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("display")
    @Expose
    private String display;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

}
