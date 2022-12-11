package com.au615584.urineanalyzerapp.Repositories;

import androidx.lifecycle.LiveData;

//Interface for BTRepository
// This makes sure to comply with Dependency Inversion Principle and strategy-pattern
// with complies with Open Close principle
public interface IBTRepository {
    void connectToRemoteDevice();

    boolean isBluetoothEnabled();

    LiveData<String> btMessage();
    LiveData<Boolean> isBtConnected();
}
