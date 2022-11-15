package com.au615584.urineanalyzerapp.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginEPJResponse {

  @SerializedName("token")
  @Expose
  private String token;
  @SerializedName("tokenExpiry")
  @Expose
  private Long tokenExpiry;
  @SerializedName("online") //TODO set as deprecated
  @Expose
  private Boolean online;
  @SerializedName("isSystemUser")
  @Expose
  private Boolean isSystemUser;

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public Long getTokenExpiry() {
    return tokenExpiry;
  }

  public void setTokenExpiry(Long tokenExpiry) {
    this.tokenExpiry = tokenExpiry;
  }

  public Boolean getOnline() {
    return online;
  }

  public void setOnline(Boolean online) {
    this.online = online;
  }

  public Boolean getIsSystemUser() {
    return isSystemUser;
  }

  public void setIsSystemUser(Boolean isSystemUser) {
    this.isSystemUser = isSystemUser;
  }

}
