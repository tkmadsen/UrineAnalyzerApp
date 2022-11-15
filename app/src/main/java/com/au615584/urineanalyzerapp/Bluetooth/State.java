package com.au615584.urineanalyzerapp.Bluetooth;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class State {
    public MutableLiveData<String> state;
    public IBluetoothConnection connection;

    public State() {
        state = new MutableLiveData<>("Welcome");
    }
    public State(IBluetoothConnection btcon){connection=btcon;}


    public void changeState(String btMessage) {
        Log.d("BTConnection", "Reached changeState()");
        Character rpiProtocol = btMessage.charAt(0);
        Log.d("BTConnection", "btMessage: " + btMessage);
        Log.d("BTConnection", "int for RpiProtocol: " + rpiProtocol);
        switch (rpiProtocol) {
            case '1':
                state.postValue("Guide");
                Log.d("State", "ChangeState(), Received 1");
                break;
            case '2':
                state.postValue("Analyzing");
                Log.d("State", "ChangeState(), Received 2");
                break;
            case '3':
                state.postValue("Result");
                Log.d("State", "ChangeState(), Received 3");
                break;
            case '4':
                state.postValue("Welcome");
                Log.d("State", "ChangeState(), Received 5");
                break;
            default:
                state.postValue("Welcome");
                Log.d("State", "ChangeState(), default");

        }
    }

    public LiveData<String> lState() {
        if(state == null) {
            state = new MutableLiveData<>();
        }
        return state;
    }
}
