package com.esys.mvvmstarter.utils;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider.Factory;
import com.esys.mvvmstarter.data.repository.SampleRepositoryImpl;
import com.esys.mvvmstarter.ui.main.MainViewModel;

public class ViewModelFactory implements Factory {

    private final Application mApplication;

    public ViewModelFactory(final Application application) {
        mApplication = application;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull final Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MainViewModel.class)) {
            return (T) new MainViewModel(new SampleRepositoryImpl(mApplication));
        }
        return null;
    }
}
