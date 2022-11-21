package com.au615584.urineanalyzerapp.Bluetooth;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.au615584.urineanalyzerapp.IController;

public class State {
    public MutableLiveData<String> state;
    public IController controller;

    public State() {
        state = new MutableLiveData<>("Welcome");
    }
    public State(IController controller){this.controller=controller;}


    public void changeState(String stateMessage) {
        Log.d("State", "StateMessage: " + stateMessage);
        if(stateMessage!= "") {
            Character stateChar = formatStateMessage(stateMessage);

            switch (stateChar) {
                case '1':
                    state.postValue("Guide");
                    Log.d("State", "ChangeState(), Received 1");
                    break;
                case '2':
                    state.postValue("Analyzing");
                    Log.d("State", "ChangeState(), Received 2");
                    break;
//            case '3':
//                state.postValue("Result");
//               Log.d("State", "ChangeState(), Received 3");
//                break;
                case '4':
                    state.postValue("Welcome");
                    Log.d("State", "ChangeState(), Received 5");
                    break;
                case 'S':
                    state.postValue("Result");
                    Log.d("State", "ChangeState(), Received S");
                    break;
                case 'F':
                    state.postValue("Result Failure");
                    Log.d("State", "ChangeState(), Received F");
                    break;
                case 'T':
                    state.postValue("Test Failure");
                    Log.d("State", "ChangeState(), Received T");
                    break;
                default:
                    state.postValue("Welcome");
                    Log.d("State", "ChangeState(), default");

            }
        } else {
            state.postValue("Welcome");
            Log.d("State", "ChangeState(), default");
        }
    }

    public Character formatStateMessage(String stateMessage) {
        Character stateChar;
        stateChar = stateMessage.charAt(0);
        Log.d("State", "stateMessage: " + stateMessage + "stateChar: " + stateChar);

        return stateChar;
    }

    public LiveData<String> lState() {
        if(state == null) {
            state = new MutableLiveData<>();
        }
        return state;
    }
}
