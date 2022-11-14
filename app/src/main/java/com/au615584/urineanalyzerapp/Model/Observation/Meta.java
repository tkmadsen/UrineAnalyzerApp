package com.au615584.urineanalyzerapp.Model.Observation;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Meta {

  @SerializedName("profile")
  @Expose
  private List<String> profile = null;

  public List<String> getProfile() {
    return profile;
  }

  public void setProfile(List<String> profile) {
    this.profile = profile;
  }

}
