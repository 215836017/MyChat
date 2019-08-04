package com.test.mychat.database;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseManager {

    private static DatabaseManager instance = null;
    private SQLiteDatabase database;
    private DataBaseHelper dataBaseHelper;

    public static DatabaseManager getInstance() {
        if (null == instance) {
            synchronized (DatabaseManager.class) {
                if (null == instance) {
                    instance = new DatabaseManager();
                }
            }
        }
        return instance;
    }

    public void openDatabase(Context context) {

        if (null == database || !database.isOpen()) {
            dataBaseHelper = new DataBaseHelper(context, DatabaseContants.DB_NAME, DatabaseContants.DB_VERSION);
            database = dataBaseHelper.getWritableDatabase();
        }
    }

    public void closeDatabase() {
        if (null != database) {
            database.close();
            database = null;
        }

        if (null != dataBaseHelper) {
            dataBaseHelper.close();
        }
    }

    public SQLiteDatabase getDatabase() {
        return database;
    }
}
