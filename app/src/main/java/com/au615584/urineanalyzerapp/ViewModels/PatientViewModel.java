package com.au615584.urineanalyzerapp.ViewModels;

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

  public LiveData<String> state() { return controller.fragmentState();}

  public LiveData<String> cpr(){ return controller.cpr();}

  public LiveData<String> btMessage(){ return controller.btMessage(); }

  public void handleBtMessage(String incomingMessage) {
    controller.handleBtMessage(incomingMessage);
  }

  public LiveData<Boolean> isBtConnedted() { return controller.isBtConnected(); }
}
