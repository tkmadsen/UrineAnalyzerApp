package com.au615584.urineanalyzerapp.Model.Observation;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Component_Extension {

  @SerializedName("url")
  @Expose
  private String url;
  @SerializedName("valueQuantity")
  @Expose
  private ValueQuantity valueQuantity;

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public ValueQuantity getValueQuantity() {
    return valueQuantity;
  }

  public void setValueQuantity(ValueQuantity valueQuantity) {
    this.valueQuantity = valueQuantity;
  }

}
