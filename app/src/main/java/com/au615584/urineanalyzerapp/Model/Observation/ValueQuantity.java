package com.au615584.urineanalyzerapp.Model.Observation;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ValueQuantity {

  @SerializedName("value")
  @Expose
  private Double value;

  public Double getValue() {
    return value;
  }

  public void setValue(Double value) {
    this.value = value;
  }

}