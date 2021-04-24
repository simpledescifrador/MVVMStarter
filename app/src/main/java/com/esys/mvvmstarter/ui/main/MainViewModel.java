package com.esys.mvvmstarter.ui.main;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.LiveData;
import com.esys.mvvmstarter.data.local.entities.SampleModel;
import com.esys.mvvmstarter.data.repository.SampleRepositoryImpl;
import com.esys.mvvmstarter.data.repository.repo_interfaces.ISampleRepository;
import com.esys.mvvmstarter.ui.base.BaseViewModel;
import com.esys.mvvmstarter.utils.threads.Threader;

public class MainViewModel extends BaseViewModel {

    private final ISampleRepository mSampleRepository;

    public MainViewModel(final SampleRepositoryImpl sampleRepository) {
        mSampleRepository = sampleRepository;
    }

    @Override
    public LiveData<Boolean> observerLoading() {
        return super.observerLoading();
    }

    public void sampleInsert() {
        mLoading.postValue(true);
        mSampleRepository.insertNewSample(new SampleModel("Sample1"));
    }
}
