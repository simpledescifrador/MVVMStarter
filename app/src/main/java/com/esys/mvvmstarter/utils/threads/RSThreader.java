package com.esys.mvvmstarter.utils.threads;

import android.os.AsyncTask;

/**
 * @see RThreader for details
 */
@SuppressWarnings("deprecation")
public class RSThreader<T> extends AsyncTask<Object, Void, T> {

    IRThreader threader;

    public RSThreader(IRThreader threader) {
        this.threader = threader;
    }

    @Override
    protected T doInBackground(Object... objects) {
        return threader.onExecute();
    }
}
