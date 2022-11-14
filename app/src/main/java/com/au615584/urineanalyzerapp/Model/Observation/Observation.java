package com.au615584.urineanalyzerapp.Model.Observation;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Observation {

  @SerializedName("resourceType")
  @Expose
  private String resourceType;
  @SerializedName("meta")
  @Expose
  private Meta meta;
  @SerializedName("contained")
  @Expose
  private List<Contained> contained = null;
  @SerializedName("extension")
  @Expose
  private List<Extension> extension = null;
  @SerializedName("basedOn")
  @Expose
  private BasedOn basedOn;
  @SerializedName("status")
  @Expose
  private String status;
  @SerializedName("code")
  @Expose
  private Code code;
  @SerializedName("subject")
  @Expose
  private Subject subject;
  @SerializedName("component")
  @Expose
  private List<Component> component = null;

  public String getResourceType() {
    return resourceType;
  }

  public void setResourceType(String resourceType) {
    this.resourceType = resourceType;
  }

  public Meta getMeta() {
    return meta;
  }

  public void setMeta(Meta meta) {
    this.meta = meta;
  }

  public List<Contained> getContained() {
    return contained;
  }

  public void setContained(List<Contained> contained) {
    this.contained = contained;
  }

  public List<Extension> getExtension() {
    return extension;
  }

  public void setExtension(List<Extension> extension) {
    this.extension = extension;
  }

  public BasedOn getBasedOn() {
    return basedOn;
  }

  public void setBasedOn(BasedOn basedOn) {
    this.basedOn = basedOn;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Code getCode() {
    return code;
  }

  public void setCode(Code code) {
    this.code = code;
  }

  public Subject getSubject() {
    return subject;
  }

  public void setSubject(Subject subject) {
    this.subject = subject;
  }

  public List<Component> getComponent() {
    return component;
  }

  public void setComponent(List<Component> component) {
    this.component = component;
  }

}
