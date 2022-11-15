package com.au615584.urineanalyzerapp;

import android.app.Activity;

import androidx.lifecycle.LiveData;

import com.au615584.urineanalyzerapp.Repositories.BTRepository;
import com.au615584.urineanalyzerapp.Repositories.IBTRepository;
import com.au615584.urineanalyzerapp.Repositories.IEPJRepository;
import com.au615584.urineanalyzerapp.Repositories.IProRepository;
import com.au615584.urineanalyzerapp.Repositories.pRepository;


public class Controller {
    //Instance for Singleton pattern
    private static Controller instance;
    private IEPJRepository EPJrepository;
    private IBTRepository btRepository;
    private IProRepository proRepository;

    //Singleton patten
    public static Controller getInstance() {

        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public Controller() {
        btRepository = BTRepository.getInstance();
        //EPJrepository = EPJRepository.getInstance(new FirebaseConnection());
        proRepository = pRepository.getInstance();
    }

    //ForEPJRepository
    //public void saveToEPJ(){EPJrepository.saveToEPJ();}

    //For proRepository
    public void signIn(String pw){proRepository.SignIn(pw);}
    public void signOut(){proRepository.SignOut();}
    public void setLocal(Activity act, String langCode){proRepository.SetLocal(act,langCode);}
    public void setStixType(Activity act, String type){proRepository.setStixType(act, type);}
    public LiveData<Boolean> isSignedIn() {
        return proRepository.isSignedIn();
    }

    //For btRepository
    public void connectToRemoteDevice(){btRepository.connectToRemoteDevice();}
    public boolean isBluetoothEnabled(){return btRepository.isBluetoothEnabled();}
    public LiveData<String> state() { return btRepository.state(); }
    public LiveData<String> cpr(){return btRepository.cpr();}
    public LiveData<String> result(){return btRepository.result();}


}
