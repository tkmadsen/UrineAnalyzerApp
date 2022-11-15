package com.au615584.urineanalyzerapp.Bluetooth;

import androidx.lifecycle.LiveData;

public interface IBluetoothCommunication {
    void connectToRemoteDevice();

    boolean isBluetoothEnabled();

    LiveData<String> fragmentState();

    LiveData<String> cprString();

    LiveData<String> resultString();
}
