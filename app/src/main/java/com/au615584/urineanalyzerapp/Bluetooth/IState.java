package com.au615584.urineanalyzerapp.Bluetooth;

import androidx.lifecycle.LiveData;

//Interface for State class.
// This makes sure to comply with Dependency Inversion Principle and strategy-pattern
// with complies with Open Close principle
public interface IState {
    void changeState(String stateMessage);
    Character formatStateMessage(String stateMessage);
    LiveData<String> lState();
}
