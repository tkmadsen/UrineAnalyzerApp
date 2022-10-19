package com.au615584.urineanalyzerapp;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.Locale;

public class Repository {
    //Instance for Singleton pattern
    private static Repository instance;
    private MutableLiveData<Boolean> isUserSignedIn;

    //Singleton patten
    public static Repository getInstance() {
        if (instance == null) {
            instance = new Repository();
        }
        return instance;
    }

    public void SignIn(String pw, Activity activity){


        if(pw.equals("1234")){
            Log.d(Constants.TAG_Rep,"User signed in");
            isUserSignedIn.postValue(true);

        }
        else{
            Log.d(Constants.TAG_Rep,"1234 ikke rigtig"+pw+"hej");
            isUserSignedIn.postValue(false);
        }
    }
    public LiveData<Boolean> isSignedIn() {
        if (isUserSignedIn == null){
            isUserSignedIn = new MutableLiveData<>();
        }
        return isUserSignedIn;
    }

//ref: https://www.youtube.com/watch?v=OprxdkVKEcc
    public void SetLocal(Activity acticity, String langCode) {
        Log.d(Constants.TAG_Rep, "SetLocal: "+langCode);
        Locale locale = new Locale(langCode);
        locale.setDefault(locale);
        Resources resources = acticity.getResources();
        Configuration config = resources.getConfiguration();
        config.setLocale(locale);
        resources.updateConfiguration(config,resources.getDisplayMetrics());
    }

    public void SignOut() {
        isUserSignedIn.postValue(false);
    }
}
