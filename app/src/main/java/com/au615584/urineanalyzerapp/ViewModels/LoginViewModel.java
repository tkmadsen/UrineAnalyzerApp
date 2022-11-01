package com.au615584.urineanalyzerapp.ViewModels;

import android.app.Activity;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.au615584.urineanalyzerapp.Constants;
import com.au615584.urineanalyzerapp.FirebaseConnection;
import com.au615584.urineanalyzerapp.IFirebaseConnection;
import com.au615584.urineanalyzerapp.Repository;

public class LoginViewModel {
    private Repository repository;

    public LoginViewModel() {
        repository = Repository.getInstance(new FirebaseConnection());
    }

    public LoginViewModel(IFirebaseConnection connection) {
        repository = Repository.getInstance(connection);
    }

    public LiveData<Boolean> isSignedIn() {
        return repository.isSignedIn();
    }
    public void SignIn(String pw, Activity activity){
        Log.d(Constants.TAG_LoginVM,"Signin kaldt"+pw);
        repository.SignIn(pw);
    }

    public void SignOut() {
        repository.SignOut();
    }
}
