package com.chat.flyingchat.injection.components;

import com.chat.flyingchat.injection.module.ActivityModule;
import com.chat.flyingchat.injection.module.ApiModule;
import com.chat.flyingchat.injection.module.AppModule;
import com.chat.flyingchat.injection.module.DatabaseModule;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {DatabaseModule.class, AppModule.class, ApiModule.class})
@Singleton
public interface AppComponent {

    ActivityComponent providesActivityComponent(ActivityModule activityModule);

}
