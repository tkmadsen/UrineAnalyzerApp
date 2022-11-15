
package com.au615584.urineanalyzerapp.Model.ObservationResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Contained {

    @SerializedName("#text")
    @Expose
    private String text;
    @SerializedName("Location")
    @Expose
    private Location location;
    @SerializedName("ProcedureRequest")
    @Expose
    private ProcedureRequest procedureRequest;
    @SerializedName("Practitioner")
    @Expose
    private Practitioner practitioner;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public ProcedureRequest getProcedureRequest() {
        return procedureRequest;
    }

    public void setProcedureRequest(ProcedureRequest procedureRequest) {
        this.procedureRequest = procedureRequest;
    }

    public Practitioner getPractitioner() {
        return practitioner;
    }

    public void setPractitioner(Practitioner practitioner) {
        this.practitioner = practitioner;
    }

}
