package com.au615584.urineanalyzerapp.ViewModels;

import android.app.Activity;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.au615584.urineanalyzerapp.FirebaseConnection;
import com.au615584.urineanalyzerapp.FragmentState;
import com.au615584.urineanalyzerapp.IFirebaseConnection;
import com.au615584.urineanalyzerapp.IRepository;
import com.au615584.urineanalyzerapp.Repository;

public class PatientViewModel {
  IRepository repository;

  public PatientViewModel() {
    repository = Repository.getInstance(new FirebaseConnection());
  }

  public PatientViewModel(IRepository repo, IFirebaseConnection connection) {
    repository=repo;
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
  public LiveData<String> cpr(){return repository.cpr();}
  public LiveData<String> result(){return repository.result();}
}
