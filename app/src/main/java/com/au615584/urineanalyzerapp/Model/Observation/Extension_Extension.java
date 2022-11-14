package com.au615584.urineanalyzerapp.Model.Observation;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Extension_Extension {

  @SerializedName("url")
  @Expose
  private String url;
  @SerializedName("valueCoding")
  @Expose
  private ValueCoding valueCoding;
  @SerializedName("valueReference")
  @Expose
  private ValueReference valueReference;

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
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