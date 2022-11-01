package com.au615584.urineanalyzerapp;

import android.app.Activity;

public interface IRepository {
    public boolean isUserSignedIn = false;
    public int Test(String input);
    public void SignIn(String pw);

}
