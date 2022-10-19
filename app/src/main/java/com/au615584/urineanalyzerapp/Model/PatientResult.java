package com.au615584.urineanalyzerapp.Model;

import java.sql.Time;
import java.sql.Timestamp;

public class PatientResult {
  public Integer cpr;
  public com.google.firebase.Timestamp dateTime;
  public String glucose;
  public String protein;
  public String clinician;
  public String hospital;
  public String practice;

  public PatientResult() {}
  public PatientResult(Integer cpr, com.google.firebase.Timestamp dateTime,
                       String glucose, String protein,
                       String clinician, String hospital,
                       String practice) {
    this.cpr = cpr;
    this.dateTime = dateTime;
    this.glucose = glucose;
    this.protein = protein;
    this.clinician = clinician;
    this.hospital = hospital;
    this.practice = practice;
  }

  public Integer getCpr() {return cpr;}
  public void setCpr(Integer cpr) {this.cpr = cpr;}

  public com.google.firebase.Timestamp getDateTime() {return dateTime;}
  public void setDateTime(com.google.firebase.Timestamp dateTime) {this.dateTime = dateTime;}


  public String getGlucose() {return glucose;}
  public void setGlucose(String glucose) {this.glucose = glucose;}

  public String getProtein() {return protein;}
  public void setProtein(String protein) {this.protein = protein;}

  public String getClinician() {return clinician;}
  public void setClinician(String clinician) {this.clinician = clinician;}

  public String getHospital() {return hospital;}
  public void setHospital(String hospital) {this.hospital = hospital;}

  public String getPractice() {return practice;}
  public void setPractice(String practice) {this.practice = practice;}



}
