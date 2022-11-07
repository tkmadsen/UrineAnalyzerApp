package com.au615584.urineanalyzerapp.Repositories;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.au615584.urineanalyzerapp.Bluetooth.BluetoothCommunication;
import com.au615584.urineanalyzerapp.Constants;
import com.au615584.urineanalyzerapp.IFirebaseConnection;

import java.util.Locale;

public class pRepository implements IProRepository{
    //Instance for Singleton pattern
    private static pRepository instance;
    public MutableLiveData<Boolean> isUserSignedIn;
    IFirebaseConnection fireBaseCon;
    private BluetoothCommunication btConnection;

    pRepository(IFirebaseConnection fireBaseCon) {
        this.fireBaseCon = fireBaseCon;
        isUserSignedIn = new MutableLiveData<>(false);
        btConnection = new BluetoothCommunication();
    }

    //Singleton patten
    public static pRepository getInstance(IFirebaseConnection connection) {

        if (instance == null) {
            instance = new pRepository(connection);
        }
        return instance;
    }
    @Override
    public void SignIn(String pw) {
        if (pw.equals("1234")) {
            Log.d(Constants.TAG_Rep, "User signed in");
            isUserSignedIn.postValue(true);

        } else {
            Log.d(Constants.TAG_Rep, "1234 ikke rigtig" + pw + "hej");
            isUserSignedIn.postValue(false);
        }

    }

    @Override
    public LiveData<Boolean> isSignedIn() {
        if (isUserSignedIn == null) {
            isUserSignedIn = new MutableLiveData<>();
        }
        return isUserSignedIn;
    }

    @Override
    public void SignOut() {
        isUserSignedIn.postValue(false);

    }

    @Override
    public void SetLocal(Activity activity, String langCode) {
        Log.d(Constants.TAG_Rep, "SetLocal: " + langCode);
        Locale locale = new Locale(langCode);
        locale.setDefault(locale);
        Resources resources = activity.getResources();
        Configuration config = resources.getConfiguration();
        config.setLocale(locale);
        resources.updateConfiguration(config, resources.getDisplayMetrics());

    }

    @Override
    public void setStixType(Activity act, String type) {

    }
}
