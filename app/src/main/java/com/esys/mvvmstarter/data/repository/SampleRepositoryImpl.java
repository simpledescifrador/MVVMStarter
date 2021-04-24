package com.esys.mvvmstarter.data.repository;

import android.content.Context;
import com.esys.mvvmstarter.data.api.ApiHelperImpl;
import com.esys.mvvmstarter.data.api.IApiHelper;
import com.esys.mvvmstarter.data.local.DbHelperImpl;
import com.esys.mvvmstarter.data.local.IDbHelper;
import com.esys.mvvmstarter.data.local.entities.SampleModel;
import com.esys.mvvmstarter.data.repository.repo_interfaces.ISampleRepository;
import java.util.List;

public class SampleRepositoryImpl implements ISampleRepository {

    private final IDbHelper mDbHelper;
    private final IApiHelper mApiHelper;

    public SampleRepositoryImpl(final Context context) {
        mDbHelper = new DbHelperImpl(context);
        mApiHelper = new ApiHelperImpl(context);
    }

    @Override
    public List<SampleModel> getSamplesLocal() {
        return mDbHelper.getSamplesOnDb();
    }

    @Override
    public void insertNewSample(final SampleModel sampleModel) {
        mDbHelper.insertNewSample(sampleModel);
    }
}
