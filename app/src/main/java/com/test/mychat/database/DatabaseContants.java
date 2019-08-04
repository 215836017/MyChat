package com.test.mychat.database;

public class DatabaseContants {

    public static final String DB_NAME = "myChat_SQLite.db3";
    public static final int DB_VERSION = 1;
    public static final String TABLE_NAME_CONTACTS = "table_contacts";
    public static final String TABLE_NAME_MSG = "table_msg";


    public static class TableContacts {
        /*
        对应于 ContactsBean.java
        private int contactsId;
        private String headPortraitPath;
        private String contactsName;
        private String pingYin;
        private boolean isLetter;
        */
        public static final String COLUMN_CONTACTS_ID = "_id";
        public static final String COLUMN_HEADPORTRAIT_PATH = "headPortraitPath";
        public static final String COLUMN_CONTACTSNAME = "contactsName";
        public static final String COLUMN_PINGYIN = "pingYin";

    }


    public static class TableMsgs {

        /*
        对应于 ChatBean.java
         */
    }
}
