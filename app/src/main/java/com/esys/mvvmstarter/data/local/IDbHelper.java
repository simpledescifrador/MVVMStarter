package com.esys.mvvmstarter.data.local;

import com.esys.mvvmstarter.data.local.entities.SampleModel;
import java.util.List;

public interface IDbHelper {
    List<SampleModel> getSamplesOnDb();
    void insertNewSample(final SampleModel sampleModel);
}
