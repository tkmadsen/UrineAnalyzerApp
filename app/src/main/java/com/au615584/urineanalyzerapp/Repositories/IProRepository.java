package com.au615584.urineanalyzerapp.Repositories;

import android.app.Activity;

import androidx.lifecycle.LiveData;

//Interface for ProRepository
// This makes sure to comply with Dependency Inversion Principle and strategy-pattern
// with complies with Open Close principle.
public interface IProRepository {
    void SignIn(String pw);

    LiveData<Boolean> isSignedIn();

    void SignOut();

    void SetLocal(Activity activity, String langCode);

    void setStixType(Activity act, String type);
}
