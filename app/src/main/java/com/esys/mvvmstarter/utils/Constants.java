package com.esys.mvvmstarter.utils;

import android.os.Environment;
import com.esys.mvvmstarter.BuildConfig;

public class Constants {

    /* APP DATABASE */
    public static final String DB_PATH = "data/" + BuildConfig.APPLICATION_ID + "/";
    public static final String DB_NAME = "data.db";
    public static final String APP_DATA_PATH = Environment.getExternalStorageDirectory().getAbsolutePath() + "/"
            + DB_PATH;

}
