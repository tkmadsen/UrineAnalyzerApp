package com.au615584.urineanalyzerapp.Repositories;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.au615584.urineanalyzerapp.Bluetooth.BluetoothCommunication;
import com.au615584.urineanalyzerapp.IFirebaseConnection;

public class BTRepository implements IBTRepository {
    //Instance for Singleton pattern
    private static BTRepository instance;
    public MutableLiveData<Boolean> isUserSignedIn;
    public MutableLiveData<String> state;
    IFirebaseConnection fireBaseCon;
    private BluetoothCommunication btConnection;

    BTRepository(IFirebaseConnection fireBaseCon) {
        this.fireBaseCon = fireBaseCon;
        isUserSignedIn = new MutableLiveData<>(false);
        state = new MutableLiveData<>("");
        btConnection = new BluetoothCommunication();
    }

    //Singleton patten
    public static BTRepository getInstance(IFirebaseConnection connection) {

        if (instance == null) {
            instance = new BTRepository(connection);
        }
        return instance;
    }

    public void connectToRemoteDevice() {
        btConnection.connectToRemoteDevice();
    }

    public boolean isBluetoothEnabled() {
        return btConnection.isBluetoothEnabled();
    }

    @Override
    public LiveData<String> state() {
        return btConnection.fragmentState();
    }

    public LiveData<String> cpr() { return btConnection.cprString();}
    public LiveData<String> result() {
        return btConnection.resultString();
    }
}
