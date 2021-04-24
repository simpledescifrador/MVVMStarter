package com.esys.mvvmstarter.data.local.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.esys.mvvmstarter.data.local.entities.SampleModel;
import java.util.List;

@Dao
public interface SampleDao {
    @Query("SELECT * FROM SAMPLE_TBL")
    List<SampleModel> getAllSample();

    @Insert
    void insertSampleModel(final SampleModel sampleModel);
}
