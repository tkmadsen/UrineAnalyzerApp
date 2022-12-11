package com.au615584.urineanalyzerapp.Bluetooth;

import androidx.lifecycle.LiveData;

//interface for IBluetoothConnection exposing public method.
// This makes sure to comply with Dependency Inversion Principle
public interface IBluetoothConnection {
    void connectToRemoteDevice();

    boolean isBluetoothEnabled();

    LiveData<String> btMessage();

    LiveData<Boolean> isBtConnected();
}
