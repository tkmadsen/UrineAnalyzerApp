package com.au615584.urineanalyzerapp;

import android.app.Activity;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.au615584.urineanalyzerapp.Bluetooth.IState;
import com.au615584.urineanalyzerapp.Bluetooth.State;
import com.au615584.urineanalyzerapp.Repositories.BTRepository;
import com.au615584.urineanalyzerapp.Repositories.EPJRepository;
import com.au615584.urineanalyzerapp.Repositories.IBTRepository;
import com.au615584.urineanalyzerapp.Repositories.IEPJRepository;
import com.au615584.urineanalyzerapp.Repositories.IProRepository;
import com.au615584.urineanalyzerapp.Repositories.ProRepository;


public class Controller implements IController{
    //Instance for Singleton pattern
    private static Controller instance;
    private IEPJRepository EPJrepository;
    private IBTRepository btRepository;
    private IProRepository proRepository;
    private IState stateC;
    public MutableLiveData<String> cpr;

    //Singleton patten
    public static Controller getInstance() {

        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public Controller() {
        btRepository = BTRepository.getInstance();
        EPJrepository = EPJRepository.getInstance();
        proRepository = ProRepository.getInstance();
        stateC = new State();
        cpr = new MutableLiveData<>("Default Cpr");
    }
    public Controller(IState state,IProRepository proRepo, IEPJRepository epjRepo, IBTRepository btRepo) {
        btRepository=btRepo;
        EPJrepository=epjRepo;
        proRepository=proRepo;
        stateC=state;
        cpr = new MutableLiveData<>("Default Cpr");
    }



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
    public LiveData<Boolean> isBtConnected(){ return btRepository.isBtConnected();}
    public LiveData<String> fragmentState() { return stateC.lState(); }

    public LiveData<String> btMessage(){
        return btRepository.btMessage();
    }

    public void handleBtMessage(String incomingMessage) {
        if(incomingMessage != "") {
            if(incomingMessage.charAt(0)=='1'){
                cpr.postValue(incomingMessage.substring(1));
                Log.d("Controller", "saveCPR: " + cpr);
            } else if (incomingMessage.charAt(0) == '3'){
                String result = incomingMessage.substring(1);
                if(result.equals("Fejl på test")) {
                    incomingMessage = "TestFejl";
                } else {
                    Boolean epjSucces = sendResultToEPJ(incomingMessage.substring(1), cpr.getValue());
                    if (epjSucces) {
                        incomingMessage = "S";
                    } else {
                        incomingMessage = "F";
                    }
                }
            }
            stateC.changeState(incomingMessage);
            Log.d("handleBtMessage", "Incomingmessage: " + incomingMessage);
        }
    }
    public LiveData<String> cpr() {
        if(cpr == null) {
            cpr = new MutableLiveData<>();
        }
        return cpr;
    }


    //For EPJRepository
    public boolean sendResultToEPJ(String result, String Cpr){
        Log.d("Controller", "Result before split: " + result);
        if(result.contains(",")) {
            String[] resultList = result.split(",");
            Log.d("Controller", resultList[0].substring(resultList[0].length()-1));
            Double glucosis = Double.parseDouble (resultList[0].substring(resultList[0].length()-1));
            Double albumin = Double.parseDouble(resultList[1].substring(resultList[1].length()-1));

            Log.d("Controller", "before saving to epj, msg: " + result);
            //boolean EPJSuccess = EPJrepository.saveResultEPJ(glucosis, albumin, Cpr); //TODO uncomment when testing api
            boolean EPJSuccess = EPJrepository.saveToLog(glucosis, albumin, Cpr);
            Log.d("Controller", "after saving to epj");
            return EPJSuccess;
        } else {
            Log.d("Controller", "Fail on test");
            return false;
        }
    }
}
