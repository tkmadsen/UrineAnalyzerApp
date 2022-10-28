package com.au615584.urineanalyzerapp.ViewModels;

import android.app.Activity;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.au615584.urineanalyzerapp.FragmentState;
import com.au615584.urineanalyzerapp.Repository;

public class PatientViewModel {
  Repository repository;

  public PatientViewModel() {
    repository = Repository.getInstance();
  }

  public void connectToRemoteDevice(){
    repository.connectToRemoteDevice();
  }

  public boolean isBluetoothEnabled() {
    return repository.isBluetoothEnabled();
  }

  public LiveData<String> state() {
    return repository.state();
  }
}
