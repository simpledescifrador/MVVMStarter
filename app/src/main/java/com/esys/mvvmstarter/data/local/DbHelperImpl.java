package com.esys.mvvmstarter.data.local;

import android.content.Context;
import com.esys.mvvmstarter.data.local.dao.SampleDao;
import com.esys.mvvmstarter.data.local.entities.SampleModel;
import com.esys.mvvmstarter.utils.threads.IRThreader;
import com.esys.mvvmstarter.utils.threads.RThreader;
import com.esys.mvvmstarter.utils.threads.Threader;
import java.util.List;
import timber.log.Timber;

@SuppressWarnings({"Anonymous2MethodRef", "unchecked"})
public class DbHelperImpl implements IDbHelper {

    private final SampleDao mSampleDao;

    public DbHelperImpl(final Context context) {
        mSampleDao = AppDatabase.getInstance(context).getSampleDao();
    }


    @Override
    public List<SampleModel> getSamplesOnDb() {
        return RThreader.rlThreader(new IRThreader() {
            @Override
            public List<SampleModel> onExecute() {
                Timber.d("getSamplesOnDb() Called!");
                return mSampleDao.getAllSample();
            }
        });
    }

    @Override
    public void insertNewSample(final SampleModel sampleModel) {
        Threader.execute(() -> {
            Timber.d("insertNewSample() Called!");
            mSampleDao.insertSampleModel(sampleModel);
        });
    }
}
