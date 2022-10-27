package com.au615584.urineanalyzerapp;

import android.app.Application;
import android.content.Context;


public class UrineAnalyzerApplication extends Application {
  private static UrineAnalyzerApplication instance;

  @Override
  public void onCreate() {
    super.onCreate();
    instance = this;
  }

  //Get application context - should only be used outside UI
  public static Context getAppContext() {
    return instance.getApplicationContext();
  }
}
