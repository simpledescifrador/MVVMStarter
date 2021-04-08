package com.esys.mvvmstarter.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 *  Base Class For All Fragments
 *  - Add Common functions  (ex: showing progress-bar, hide progress-bar)
 *  - Variable Uses with Fragments
 */
public abstract class BaseFragment extends Fragment {

  /**
   * @param context Activity context
   *  Load ViewModels here
   */
  @Override
  public void onAttach(@NonNull Context context) {
    super.onAttach(context);
    loadViewModels();
  }

  /**
   * Call Init Views Here & Observers from ViewModel
   */
  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    initViews(view);
    observers();
  }

  /**
   *  Load All ViewModels Here
   */
  protected abstract void loadViewModels();


  /** Preparing Views Must Add Here
   * @param view Fragment View
   */
  protected abstract void initViews(View view);

  /**
   *  Add Observers Here
   */
  protected abstract void observers();
}
