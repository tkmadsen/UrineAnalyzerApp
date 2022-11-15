package com.au615584.urineanalyzerapp.Repositories;

import androidx.lifecycle.LiveData;

public interface IBTRepository {
    void connectToRemoteDevice();

    boolean isBluetoothEnabled();

    LiveData<String> state();
    LiveData<String> cpr();

    LiveData<String> result();
    LiveData<Boolean> isBtConnected();
}
