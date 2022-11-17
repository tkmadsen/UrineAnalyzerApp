package com.au615584.urineanalyzerapp;

import android.app.Activity;

import androidx.lifecycle.LiveData;

public interface IController {
    LiveData<Boolean> isSignedIn();

    void signIn(String pw);

    void signOut();

    void connectToRemoteDevice();

    boolean isBluetoothEnabled();

    LiveData<String> state();

    LiveData<String> cpr();
    LiveData<String> result();

    LiveData<Boolean> isBtConnected();

    void setLocal(Activity activity, String langCode);
}
