package com.test.mychat.database.sqlutil;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.test.mychat.database.DatabaseContants;
import com.test.mychat.database.DatabaseManager;
import com.test.mychat.databean.ContactsBean;
import com.test.mychat.utils.PinyinUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TableContactsHelper {


    public static long insertContacts(String name, String headPortraitPath) {
        String pinYing = PinyinUtil.getPinYinHeadChar(name);

        SQLiteDatabase database = DatabaseManager.getInstance().getDatabase();
        if (null != database) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(DatabaseContants.TableContacts.COLUMN_CONTACTSNAME, name);
            contentValues.put(DatabaseContants.TableContacts.COLUMN_PINGYIN, pinYing);
            contentValues.put(DatabaseContants.TableContacts.COLUMN_CONTACTSNAME, headPortraitPath);
            return database.insert(DatabaseContants.TABLE_NAME_CONTACTS, null, contentValues);
        }
        return -1;
    }

    public static List<ContactsBean> queryAllContactsOrderByPinying() {
        List<ContactsBean> contactsBeanList = new ArrayList<>();

        SQLiteDatabase database = DatabaseManager.getInstance().getDatabase();
        Cursor cursor = database.query(DatabaseContants.TABLE_NAME_CONTACTS, null, null, null,
                null, null, DatabaseContants.TableContacts.COLUMN_PINGYIN);

        if (null != cursor && cursor.getCount() > 0) {
            Map<String, String> map = new HashMap<>();

            while (cursor.moveToNext()) {
                int id = cursor.getInt(cursor.getColumnIndex(DatabaseContants.TableContacts.COLUMN_CONTACTS_ID));
                String name = cursor.getString(cursor.getColumnIndex(DatabaseContants.TableContacts.COLUMN_CONTACTSNAME));
                String pingYin = cursor.getString(cursor.getColumnIndex(DatabaseContants.TableContacts.COLUMN_PINGYIN));
                String headportraitPath = cursor.getString(cursor.getColumnIndex(DatabaseContants.TableContacts.COLUMN_HEADPORTRAIT_PATH));

                ContactsBean contactsBean;
                String firstLetter = Character.toString(pingYin.charAt(0));
                if (map.containsKey(firstLetter)) {
                    contactsBean = new ContactsBean(id, headportraitPath, name, pingYin, true);
                } else {
                    contactsBean = new ContactsBean(-1, null, null,
                            null, false);
                    map.put(firstLetter, firstLetter);
                }
                contactsBeanList.add(contactsBean);
            }
        }

        return contactsBeanList;
    }
}
