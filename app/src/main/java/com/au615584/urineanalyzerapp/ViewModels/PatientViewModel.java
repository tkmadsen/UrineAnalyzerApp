package com.au615584.urineanalyzerapp.ViewModels;

import androidx.lifecycle.LiveData;

import com.au615584.urineanalyzerapp.Controller;

public class PatientViewModel {
  Controller controller;

  public PatientViewModel() {
    controller = Controller.getInstance();
  }

  public PatientViewModel(Controller control) {
    controller=control;
  }

  public void connectToRemoteDevice(){
    controller.connectToRemoteDevice();
  }

  public boolean isBluetoothEnabled() {
    return controller.isBluetoothEnabled();
  }

  public LiveData<String> state() {
    return controller.state();
  }
  public LiveData<String> cpr(){return controller.cpr();}
  public LiveData<String> result(){return controller.result();}
}
