package com.esys.mvvmstarter.utils.threads;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;


/**
 * A simple async task with no return value
 *
 * */
@SuppressWarnings("deprecation")
public class Threader extends AsyncTask<Runnable,Void,Void> {
    public Threader() {
    }
    Context context;
    ThreaderCallback callback;
    public Threader(ThreaderCallback callback) {
        this.callback=callback;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        if(callback!=null)
            callback.onPostExecute();
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if(callback!=null)
            callback.onPreExecute();
    }


    @Override
    protected Void doInBackground(Runnable... runnables) {
        Handler h = new Handler();
        h.post(runnables[0]);
        return null;
    }


}
