package com.au615584.urineanalyzerapp.Repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.au615584.urineanalyzerapp.Bluetooth.BluetoothConnection;
import com.au615584.urineanalyzerapp.Bluetooth.IBluetoothConnection;

//BTRepository handles communication and control of BluetoothConnection
public class BTRepository implements IBTRepository {
    //Instance for Singleton pattern
    private static BTRepository instance;
    public MutableLiveData<Boolean> isUserSignedIn;
    private IBluetoothConnection btConnection;

    BTRepository() {
        isUserSignedIn = new MutableLiveData<>(false);
        btConnection = new BluetoothConnection();
    }

    BTRepository(IBluetoothConnection btCon) {
        btConnection=btCon;
    }

    //Singleton patten
    public static BTRepository getInstance() {

        if (instance == null) {
            instance = new BTRepository();
        }
        return instance;
    }

    public void connectToRemoteDevice() {
        btConnection.connectToRemoteDevice();
    }

    public boolean isBluetoothEnabled() {
        return btConnection.isBluetoothEnabled();
    }

    public LiveData<String> btMessage() { return btConnection.btMessage(); }
    public LiveData<Boolean> isBtConnected() { return  btConnection .isBtConnected(); }
}
