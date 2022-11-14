package com.au615584.urineanalyzerapp.Model.Observation;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BasedOn {

  @SerializedName("reference")
  @Expose
  private String reference;

  public String getReference() {
    return reference;
  }

  public void setReference(String reference) {
    this.reference = reference;
  }

}