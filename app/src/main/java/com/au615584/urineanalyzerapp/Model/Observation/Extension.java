package com.au615584.urineanalyzerapp.Model.Observation;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Extension {

  @SerializedName("url")
  @Expose
  private String url;
  @SerializedName("extension")
  @Expose
  private List<Extension_Extension> extension = null;
  @SerializedName("valueDateTime")
  @Expose
  private String valueDateTime;

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public List<Extension_Extension> getExtension() {
    return extension;
  }

  public void setExtension(List<Extension_Extension> extension) {
    this.extension = extension;
  }

  public String getValueDateTime() {
    return valueDateTime;
  }

  public void setValueDateTime(String valueDateTime) {
    this.valueDateTime = valueDateTime;
  }

}
