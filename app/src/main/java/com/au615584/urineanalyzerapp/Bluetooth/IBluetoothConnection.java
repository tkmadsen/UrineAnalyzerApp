package com.au615584.urineanalyzerapp.Bluetooth;

import androidx.lifecycle.LiveData;

public interface IBluetoothConnection {
    void connectToRemoteDevice();

    boolean isBluetoothEnabled();

    LiveData<String> fragmentState();

    LiveData<String> cprString();

    LiveData<String> resultString();

    LiveData<Boolean> isBtConnected();
}
