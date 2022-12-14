package com.au615584.urineanalyzerapp;

import android.app.Activity;

import androidx.lifecycle.LiveData;

//Interface for controller
// This makes sure to comply with Dependency Inversion Principle
public interface IController {
    LiveData<Boolean> isSignedIn();

    void signIn(String pw);

    void signOut();

    void connectToRemoteDevice();

    boolean isBluetoothEnabled();
    void handleBtMessage(String incomingMessage);

    LiveData<String> btMessage();
    LiveData<String> fragmentState();
    LiveData<String> cpr();
    LiveData<Boolean> isBtConnected();

    void setLocal(Activity activity, String langCode);
}
