package com.au615584.urineanalyzerapp.Model.Observation;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Component {

  @SerializedName("extension")
  @Expose
  private List<Component_Extension> extension = null;
  @SerializedName("code")
  @Expose
  private Code code;

  public List<Component_Extension> getExtension() {
    return extension;
  }

  public void setExtension(List<Component_Extension> extension) {
    this.extension = extension;
  }

  public Code getCode() {
    return code;
  }

  public void setCode(Code code) {
    this.code = code;
  }

}
