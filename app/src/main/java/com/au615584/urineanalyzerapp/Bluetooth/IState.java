package com.au615584.urineanalyzerapp.Bluetooth;

import androidx.lifecycle.LiveData;

public interface IState {
    void changeState(String stateMessage);
    Character formatStateMessage(String stateMessage);
    LiveData<String> lState();
}
