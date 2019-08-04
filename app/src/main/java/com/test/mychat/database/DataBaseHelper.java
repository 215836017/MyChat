package com.test.mychat.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.support.annotation.RequiresApi;

import com.test.mychat.utils.LogUtil;

public class DataBaseHelper extends SQLiteOpenHelper {

    private final String TAG = "DataBaseHelper";

    public DataBaseHelper(Context context, String name, int version) {
        super(context, name, null, version);
    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    public DataBaseHelper(Context context, String name,
                          int version, SQLiteDatabase.OpenParams openParams) {
        super(context, name, version, openParams);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //建表语句
        String sqlContacts = "create table " + DatabaseContants.TABLE_NAME_CONTACTS +
                "(" +
                DatabaseContants.TableContacts.COLUMN_CONTACTS_ID + " integer primary key AUTOINCREMENT, " +
                DatabaseContants.TableContacts.COLUMN_CONTACTSNAME + " TEXT NOT NULL, " +
                DatabaseContants.TableContacts.COLUMN_PINGYIN + " TEXT NOT NULL, " +
                DatabaseContants.TableContacts.COLUMN_HEADPORTRAIT_PATH + " TEXT NOT NULL " +
                ")";
        //执行建表语句
        db.execSQL(sqlContacts);

        //建表语句
//        String sqlMsg = "create table " + DatabaseContants.TABLE_NAME_MSG +
//                "(" +
//                DatabaseContants.TableContacts.COLUMN_CONTACTS_ID + " integer primary key AUTOINCREMENT, " +
//                DatabaseContants.TableContacts.COLUMN_CONTACTSNAME + " TEXT NOT NULL, " +
//                DatabaseContants.TableContacts.COLUMN_HEADPORTRAIT_PATH + " TEXT NOT NULL " +
//                ")";
        //执行建表语句
//        db.execSQL(sqlMsg);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        LogUtil.i(TAG, "更新数据库");
    }
}
