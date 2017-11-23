package com.chat.flyingchat;

import android.app.Application;

import com.chat.flyingchat.injection.components.AppComponent;
import com.chat.flyingchat.injection.components.DaggerAppComponent;
import com.chat.flyingchat.injection.module.AppModule;
import com.chat.flyingchat.injection.module.DatabaseModule;

public class App extends Application {

    private static AppComponent mComponent;

    public AppComponent getComponent() {
        return mComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mComponent = buildComponent();
    }

    protected AppComponent buildComponent(){
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .databaseModule(new DatabaseModule())
                .build();
    }
}
