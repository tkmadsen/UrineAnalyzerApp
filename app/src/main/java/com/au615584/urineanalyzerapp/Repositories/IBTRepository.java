package com.au615584.urineanalyzerapp.Repositories;

import androidx.lifecycle.LiveData;

public interface IBTRepository {
    void connectToRemoteDevice();

    boolean isBluetoothEnabled();

    LiveData<String> btMessage();
    LiveData<Boolean> isBtConnected();
}
