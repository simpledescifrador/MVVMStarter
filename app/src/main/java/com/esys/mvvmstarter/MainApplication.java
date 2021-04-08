package com.esys.mvvmstarter;

import android.app.Application;

import com.karumi.dexter.BuildConfig;

import timber.log.Timber;

public class MainApplication extends Application {
  @Override
  public void onCreate() {
    super.onCreate();
    if (BuildConfig.DEBUG) {
      Timber.plant(new Timber.DebugTree());
    }
  }
}