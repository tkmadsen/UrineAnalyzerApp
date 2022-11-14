package com.au615584.urineanalyzerapp.Model.Observation;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Coding_Code {

  @SerializedName("coding")
  @Expose
  private List<Coding> coding = null;

  public List<Coding> getCoding() {
    return coding;
  }

  public void setCoding(List<Coding> coding) {
    this.coding = coding;
  }

}
