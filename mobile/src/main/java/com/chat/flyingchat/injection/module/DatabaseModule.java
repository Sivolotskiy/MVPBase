package com.chat.flyingchat.injection.module;

import android.content.Context;
import android.support.annotation.NonNull;

import com.chat.flyingchat.database.DatabaseManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DatabaseModule {

    @Provides
    @NonNull
    @Singleton
    public DatabaseManager provideDatabaseModule(@NonNull Context appContext) {
        return new DatabaseManager(appContext);
    }
}
