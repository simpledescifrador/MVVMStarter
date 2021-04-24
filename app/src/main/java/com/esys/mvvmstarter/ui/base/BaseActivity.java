package com.esys.mvvmstarter.ui.base;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


/**
 * Base Class For All Activities
 * - Add Common functions  (ex: showing progress-bar, hide progress-bar)
 * - Variable Uses with Activity
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadViewModels();
    }

    /**
     * Call Init Views Here & Observers from ViewModel
     */
    @Override
    protected void onStart() {
        super.onStart();
        initViews();
        observers();
    }

    /**
     * Load All ViewModels Here
     */
    protected abstract void loadViewModels();

    /**
     * Preparing Views Must Add Here
     */
    protected abstract void initViews();

    /**
     * Add Observers Here
     */
    protected abstract void observers();
}
