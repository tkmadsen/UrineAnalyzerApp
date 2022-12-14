package com.au615584.urineanalyzerapp.Model.Observation;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Identifier {

  @SerializedName("system")
  @Expose
  private String system;
  @SerializedName("value")
  @Expose
  private String value;

  public String getSystem() {
    return system;
  }

  public void setSystem(String system) {
    this.system = system;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

}

