package com.esys.mvvmstarter.ui.main;

import android.os.Bundle;

import com.esys.mvvmstarter.databinding.ActivityMainBinding;
import com.esys.mvvmstarter.ui.base.BaseActivity;

import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends BaseActivity {

  private MainViewModel mMainViewModel;
  private ActivityMainBinding mMainBinding;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    //Inflate View Binding here inside onCreate()
    mMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
    setContentView(mMainBinding.getRoot());
  }

  @Override
  protected void loadViewModels() {
    mMainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
  }

  @Override
  protected void initViews() {
  }

  @Override
  protected void observers() {
    //Observer Loading Dialog
    mMainViewModel.observerLoading().observe(this, loading -> {
      if (loading) {
        //Show Loading Here
      } else {
        //Hide Loading Here
      }
    });
  }
}