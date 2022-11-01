package com.au615584.urineanalyzerapp;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.au615584.urineanalyzerapp.Bluetooth.BluetoothCommunication;
import com.au615584.urineanalyzerapp.Bluetooth.BluetoothConnection;
import com.au615584.urineanalyzerapp.Model.PatientResult;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.Locale;

public class Repository implements IRepository{
    //Instance for Singleton pattern
    private static Repository instance;
    public MutableLiveData<Boolean> isUserSignedIn;
    public boolean testBool;
    IFirebaseConnection fireBaseCon;
    private DocumentReference patientResultsRef;
    private BluetoothCommunication btConnection;
    private MutableLiveData<String> state;

    Repository(IFirebaseConnection fireBaseCon) {
        this.fireBaseCon = fireBaseCon;
        isUserSignedIn = new MutableLiveData<>(false);
        testBool=new Boolean(false);
        btConnection = new BluetoothCommunication();
    }

    //Singleton patten
    public static Repository getInstance(IFirebaseConnection connection) {

        if (instance == null) {
            instance = new Repository(connection);
        }
        return instance;
    }

    public int Test(String input){
        if(input.equals("hej")){
            return 2;
        }
        else{return 0;}
    }

    public void SignIn(String pw) {
        if (pw.equals("1234")) {
            Log.d(Constants.TAG_Rep, "User signed in");
            isUserSignedIn.postValue(true);
            testBool=true;

        } else {
            Log.d(Constants.TAG_Rep, "1234 ikke rigtig" + pw + "hej");
            isUserSignedIn.postValue(false);
        }
    }

    public LiveData<Boolean> isSignedIn() {
        if (isUserSignedIn == null) {
            isUserSignedIn = new MutableLiveData<>();
        }
        return isUserSignedIn;
    }

    //ref: https://www.youtube.com/watch?v=OprxdkVKEcc
    public void SetLocal(Activity activity, String langCode) {
        Log.d(Constants.TAG_Rep, "SetLocal: " + langCode);
        Locale locale = new Locale(langCode);
        locale.setDefault(locale);
        Resources resources = activity.getResources();
        Configuration config = resources.getConfiguration();
        config.setLocale(locale);
        resources.updateConfiguration(config, resources.getDisplayMetrics());
    }

    public void SignOut() {
        isUserSignedIn.postValue(false);
    }

    public void addPatientResult() {//Integer cpr, String glucose, String protein, String clinician, String hospital, String practice) {
        fireBaseCon.addPatientResult();
    }

  public void connectToRemoteDevice() {
        btConnection.connectToRemoteDevice();
  }

  public boolean isBluetoothEnabled() {
        return btConnection.isBluetoothEnabled();
  }

  public LiveData<String> state() {
        return btConnection.fragmentState();
  }
}
