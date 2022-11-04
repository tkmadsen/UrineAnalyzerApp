package com.au615584.urineanalyzerapp;

import android.util.Log;

import androidx.annotation.NonNull;

import com.au615584.urineanalyzerapp.Model.PatientResult;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.lang.reflect.Array;

public class FirebaseConnection implements IFirebaseConnection{
    FirebaseFirestore db;
    private DocumentReference patientResultsRef;

    public FirebaseConnection() {
        db = FirebaseFirestore.getInstance();
    }
    public void addPatientResult(String cprNo, String result) {//Integer cpr, String glucose, String protein, String clinician, String hospital, String practice) {
      int cpr = Integer.parseInt(cprNo);
      String[] results = result.split(",");
      results[0] = results[0].substring(6);
      results[1] = results[1].substring(6);
      PatientResult patientResult = new PatientResult(cpr, Timestamp.now(), results[0], results[1], "Emma", "Auh", "Aarhus Jordemoderpraksis");

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

}
