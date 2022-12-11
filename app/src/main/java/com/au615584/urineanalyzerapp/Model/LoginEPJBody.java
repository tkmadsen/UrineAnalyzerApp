package com.au615584.urineanalyzerapp.Model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


//The GSON object used to create the LoginActivity JSON object sent to EPJ to authenticate the system
//Is required before sending the test results to EPJ.
public class LoginEPJBody {

  @SerializedName("securityPrincipalId")
  @Expose
  private String securityPrincipalId;
  @SerializedName("password")
  @Expose
  private String password;
  @SerializedName("role")
  @Expose
  private String role;
  @SerializedName("unit")
  @Expose
  private String unit;
  @SerializedName("createSession")
  @Expose
  private Boolean createSession;
  @SerializedName("tokenLifeTime")
  @Expose
  private Integer tokenLifeTime;

  public String getSecurityPrincipalId() {
    return securityPrincipalId;
  }

  public void setSecurityPrincipalId(String securityPrincipalId) {
    this.securityPrincipalId = securityPrincipalId;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public String getUnit() {
    return unit;
  }

  public void setUnit(String unit) {
    this.unit = unit;
  }

  public Boolean getCreateSession() {
    return createSession;
  }

  public void setCreateSession(Boolean createSession) {
    this.createSession = createSession;
  }

  public Integer getTokenLifeTime() {
    return tokenLifeTime;
  }

  public void setTokenLifeTime(Integer tokenLifeTime) {
    this.tokenLifeTime = tokenLifeTime;
  }

}