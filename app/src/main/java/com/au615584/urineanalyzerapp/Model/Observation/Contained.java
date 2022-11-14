package com.au615584.urineanalyzerapp.Model.Observation;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Contained {

  @SerializedName("resourceType")
  @Expose
  private String resourceType;
  @SerializedName("id")
  @Expose
  private String id;
  @SerializedName("meta")
  @Expose
  private Meta meta;
  @SerializedName("identifier")
  @Expose
  private List<Identifier> identifier = null;
  @SerializedName("name")
  @Expose
  private String name;
  @SerializedName("type")
  @Expose
  private Type type;
  @SerializedName("status")
  @Expose
  private String status;
  @SerializedName("intent")
  @Expose
  private String intent;
  @SerializedName("code")
  @Expose
  private Coding_Code codingCode;

  public String getResourceType() {
    return resourceType;
  }

  public void setResourceType(String resourceType) {
    this.resourceType = resourceType;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Meta getMeta() {
    return meta;
  }

  public void setMeta(Meta meta) {
    this.meta = meta;
  }

  public List<Identifier> getIdentifier() {
    return identifier;
  }

  public void setIdentifier(List<Identifier> identifier) {
    this.identifier = identifier;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Type getType() {
    return type;
  }

  public void setType(Type type) {
    this.type = type;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getIntent() {
    return intent;
  }

  public void setIntent(String intent) {
    this.intent = intent;
  }

  public Coding_Code getCode() {
    return codingCode;
  }

  public void setCode(Coding_Code codingCode) {
    this.codingCode = codingCode;
  }

}