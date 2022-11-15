package com.au615584.urineanalyzerapp;

import android.app.Activity;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.au615584.urineanalyzerapp.Repositories.BTRepository;
import com.au615584.urineanalyzerapp.Repositories.EPJRepository;
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
        btRepository = BTRepository.getInstance(new FirebaseConnection());
        EPJrepository = EPJRepository.getInstance();
        proRepository = pRepository.getInstance(new FirebaseConnection());
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
    public LiveData<Boolean> isBtConnected(){ return btRepository.isBtConnected();}

    public LiveData<String> result(){
        sendResultToEPJ();
        return btRepository.result();
    }

    //For EPJRepository
    public void sendResultToEPJ(){
        String result = btRepository.result().toString();
        if(result.contains(",")) {
            String[] resultList = result.split(",");
            double glukose = Double.parseDouble(resultList[0].substring(resultList[0].length()));
            double albumin = Double.parseDouble(resultList[1].substring(resultList[1].length()));
            EPJrepository.saveToEPJ(glukose, albumin, btRepository.cpr().toString());
        } else {
            Log.d("Controller", "Fail on test");
        }
    }


}
