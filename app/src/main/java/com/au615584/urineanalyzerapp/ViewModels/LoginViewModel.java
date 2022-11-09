package com.au615584.urineanalyzerapp.ViewModels;

import android.app.Activity;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.au615584.urineanalyzerapp.Constants;
import com.au615584.urineanalyzerapp.Controller;
import com.au615584.urineanalyzerapp.FirebaseConnection;
import com.au615584.urineanalyzerapp.IFirebaseConnection;
import com.au615584.urineanalyzerapp.Repositories.IEPJRepository;
import com.au615584.urineanalyzerapp.Repositories.EPJRepository;
import com.au615584.urineanalyzerapp.Repositories.IProRepository;
import com.au615584.urineanalyzerapp.Repositories.pRepository;

public class LoginViewModel {
    private Controller controller;

    public LoginViewModel() {
        controller = Controller.getInstance();
    }

    public LoginViewModel(Controller control) {
        controller=control;
    }

    public LiveData<Boolean> isSignedIn() {
        return controller.isSignedIn();
    }
    public void SignIn(String pw, Activity activity){
        Log.d(Constants.TAG_LoginVM,"Signin kaldt"+pw);
        controller.signIn(pw);
    }

    public void SignOut() {
        controller.signOut();
    }
}
