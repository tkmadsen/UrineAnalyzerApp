
package com.au615584.urineanalyzerapp.Model.ObservationResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Extension__1 {

    @SerializedName("#text")
    @Expose
    private String text;
    @SerializedName("valueCoding")
    @Expose
    private ValueCoding valueCoding;
    @SerializedName("valueReference")
    @Expose
    private ValueReference valueReference;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ValueCoding getValueCoding() {
        return valueCoding;
    }

    public void setValueCoding(ValueCoding valueCoding) {
        this.valueCoding = valueCoding;
    }

    public ValueReference getValueReference() {
        return valueReference;
    }

    public void setValueReference(ValueReference valueReference) {
        this.valueReference = valueReference;
    }

}
