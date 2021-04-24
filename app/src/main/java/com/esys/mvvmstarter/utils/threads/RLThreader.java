package com.esys.mvvmstarter.utils.threads;

import android.os.AsyncTask;
import java.util.List;

/**
 * @see RThreader for details
 */
@SuppressWarnings("deprecation")
public class RLThreader<T> extends AsyncTask<Object, Void, List<T>> {

    IRThreader threader;

    public RLThreader(IRThreader threader) {
        this.threader = threader;
    }

    @Override
    protected List<T> doInBackground(Object... objects) {
        return threader.onExecute();
    }
}