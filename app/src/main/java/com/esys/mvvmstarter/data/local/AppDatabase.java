package com.esys.mvvmstarter.data.local;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.esys.mvvmstarter.data.local.dao.SampleDao;
import com.esys.mvvmstarter.data.local.entities.SampleModel;
import com.esys.mvvmstarter.utils.Constants;
import java.io.File;

@Database(entities = {SampleModel.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE = null;

    public abstract SampleDao getSampleDao();

    public static synchronized AppDatabase getInstance(final Context context) {
        if (INSTANCE == null) {
            File folder = new File(Constants.APP_DATA_PATH);
            if (!folder.exists()) {
                folder.mkdirs();
            }
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, Constants.APP_DATA_PATH + Constants.DB_NAME)
                    .build();

        }

        return INSTANCE;
    }
}
