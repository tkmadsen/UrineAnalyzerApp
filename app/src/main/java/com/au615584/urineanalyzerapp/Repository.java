package com.au615584.urineanalyzerapp;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
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

public class Repository {
    //Instance for Singleton pattern
    private static Repository instance;
    private MutableLiveData<Boolean> isUserSignedIn;
    FirebaseFirestore db;
    private DocumentReference patientResultsRef;
    private BluetoothCommunication btConnection;

    private Repository() {
        db = FirebaseFirestore.getInstance();
        btConnection = new BluetoothCommunication();
    }

    //Singleton patten
    public static Repository getInstance() {

        if (instance == null) {
            instance = new Repository();
        }
        return instance;
    }

    public void SignIn(String pw, Activity activity) {


        if (pw.equals("1234")) {
            Log.d(Constants.TAG_Rep, "User signed in");
            isUserSignedIn.postValue(true);

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
        PatientResult patientResult = new PatientResult(1234567888, Timestamp.now(), "4+", "Negativ", "Emma", "Auh", "Aarhus Jordemoderpraksis");

        //Writing to database
        db.collection("Patient")
                .add(patientResult)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference patientResultsRef) {
                        Log.d("AddPatientResult, onSuccess", "DocumentSnapshot added with ID: " + patientResultsRef.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("AddPatientResult, onFailure", "Error adding document", e);
                    }
                });
    }

  public void connectToRemoteDevice() {
        btConnection.connectToRemoteDevice();
  }

  public boolean isBluetoothEnabled() {
        return btConnection.isBluetoothEnabled();
  }

  /*
  public String receiveMessage() {
        return btConnection.recive();
  }

   */

}
