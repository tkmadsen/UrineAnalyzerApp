package com.au615584.urineanalyzerapp.Bluetooth;

import androidx.lifecycle.LiveData;

public interface IBluetoothConnection {
    void connectToRemoteDevice();

    boolean isBluetoothEnabled();

    LiveData<String> btMessage();

    LiveData<Boolean> isBtConnected();
}
