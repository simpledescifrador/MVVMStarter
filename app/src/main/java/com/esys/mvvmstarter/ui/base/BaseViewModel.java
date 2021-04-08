package com.esys.mvvmstarter.ui.base;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 *  Base ViewModel Class
 *   - Add Common Functions
 */
public abstract class BaseViewModel extends ViewModel {

  /*
   REMOVE THIS IF DON'T NEED THIS
   -------------------------------
   */
  private MutableLiveData<Boolean> mLoading = new MutableLiveData<>(false);
  protected LiveData<Boolean> observerLoading() {
    return mLoading;
  }
  /*
   -------------------------------
   */

}
