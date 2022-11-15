
package com.au615584.urineanalyzerapp.Model.ObservationResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Extension__2 {

    @SerializedName("#text")
    @Expose
    private String text;
    @SerializedName("valueCodeableConcept")
    @Expose
    private ValueCodeableConcept valueCodeableConcept;
    @SerializedName("valueQuantity")
    @Expose
    private ValueQuantity valueQuantity;
    @SerializedName("valueString")
    @Expose
    private String valueString;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ValueCodeableConcept getValueCodeableConcept() {
        return valueCodeableConcept;
    }

    public void setValueCodeableConcept(ValueCodeableConcept valueCodeableConcept) {
        this.valueCodeableConcept = valueCodeableConcept;
    }

    public ValueQuantity getValueQuantity() {
        return valueQuantity;
    }

    public void setValueQuantity(ValueQuantity valueQuantity) {
        this.valueQuantity = valueQuantity;
    }

    public String getValueString() {
        return valueString;
    }

    public void setValueString(String valueString) {
        this.valueString = valueString;
    }

}
