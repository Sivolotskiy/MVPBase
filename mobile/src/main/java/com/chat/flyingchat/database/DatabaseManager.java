package com.chat.flyingchat.database;

import android.content.Context;

import io.realm.Realm;


public class DatabaseManager {

    private static final String TAG = "DatabaseManager";

    private Realm mRealm;
    private Context mContext;

    // Initialize Realm
    public DatabaseManager(Context context) {
        Realm.init(context);
        mRealm = Realm.getDefaultInstance();
        mContext = context;
    }
}
