package com.au615584.urineanalyzerapp;

import android.util.Log;

import androidx.annotation.NonNull;

import com.au615584.urineanalyzerapp.Model.PatientResult;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class FirebaseConnection implements IFirebaseConnection{
    FirebaseFirestore db;
    private DocumentReference patientResultsRef;

    FirebaseConnection() {
        db = FirebaseFirestore.getInstance();
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
}
