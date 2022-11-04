package com.au615584.urineanalyzerapp;

import android.app.Activity;

import androidx.lifecycle.LiveData;

public interface IRepository {
    public boolean isUserSignedIn = false;
    public int Test(String input);
    public void SignIn(String pw);

    LiveData<Boolean> isSignedIn();

    void SignOut();

    void connectToRemoteDevice();

    boolean isBluetoothEnabled();

    LiveData<String> state();

    void SetLocal(Activity activity, String langCode);

    LiveData<String> cpr();

    LiveData<String> result();
}
