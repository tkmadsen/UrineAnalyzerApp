package com.au615584.urineanalyzerapp.Repositories;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.au615584.urineanalyzerapp.Bluetooth.BluetoothCommunication;
import com.au615584.urineanalyzerapp.Constants;
import com.au615584.urineanalyzerapp.IFirebaseConnection;

import java.util.Locale;

public class EPJRepository implements IEPJRepository {
    //Instance for Singleton pattern
    private static EPJRepository instance;
    public MutableLiveData<Boolean> isUserSignedIn;
    IFirebaseConnection fireBaseCon;
    private BluetoothCommunication btConnection;

    EPJRepository(IFirebaseConnection fireBaseCon) {
        this.fireBaseCon = fireBaseCon;
        isUserSignedIn = new MutableLiveData<>(false);
        btConnection = new BluetoothCommunication();
    }

    //Singleton patten
    public static EPJRepository getInstance(IFirebaseConnection connection) {

        if (instance == null) {
            instance = new EPJRepository(connection);
        }
        return instance;
    }


    @Override
    public void saveToEPJ() {

    }
}
