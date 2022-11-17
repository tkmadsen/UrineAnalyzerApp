package com.au615584.urineanalyzerapp.ViewModels;

import android.util.Log;

import androidx.lifecycle.LiveData;

import com.au615584.urineanalyzerapp.Controller;
import com.au615584.urineanalyzerapp.IController;

public class PatientViewModel {
  IController controller;

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
  public LiveData<String> cpr(){
    Log.d("PatientViewModel", "Calling controller");
    return controller.cpr();}

  public LiveData<String> result(){
    Log.d("PatientViewModel", "Calling controller");
    return controller.result();}

  public LiveData<Boolean> isBtConnedted() { return controller.isBtConnected(); }
}
