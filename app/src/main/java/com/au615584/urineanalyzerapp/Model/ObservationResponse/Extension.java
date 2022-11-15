
package com.au615584.urineanalyzerapp.Model.ObservationResponse;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Extension {

    @SerializedName("#text")
    @Expose
    private String text;
    @SerializedName("extension")
    @Expose
    private List<Extension__1> extension = null;
    @SerializedName("valueDateTime")
    @Expose
    private String valueDateTime;
    @SerializedName("valueReference")
    @Expose
    private ValueReference__1 valueReference;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Extension__1> getExtension() {
        return extension;
    }

    public void setExtension(List<Extension__1> extension) {
        this.extension = extension;
    }

    public String getValueDateTime() {
        return valueDateTime;
    }

    public void setValueDateTime(String valueDateTime) {
        this.valueDateTime = valueDateTime;
    }

    public ValueReference__1 getValueReference() {
        return valueReference;
    }

    public void setValueReference(ValueReference__1 valueReference) {
        this.valueReference = valueReference;
    }

}
