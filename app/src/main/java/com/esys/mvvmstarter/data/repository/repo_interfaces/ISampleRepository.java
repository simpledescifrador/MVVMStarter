package com.esys.mvvmstarter.data.repository.repo_interfaces;

import com.esys.mvvmstarter.data.local.entities.SampleModel;
import java.util.List;

public interface ISampleRepository {
    List<SampleModel> getSamplesLocal();
    void insertNewSample(final SampleModel sampleModel);
}
