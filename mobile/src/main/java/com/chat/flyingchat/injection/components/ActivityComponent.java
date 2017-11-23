package com.chat.flyingchat.injection.components;

import com.chat.flyingchat.injection.module.ActivityModule;
import com.chat.flyingchat.injection.module.FragmentModule;
import com.chat.flyingchat.ui.activity.MainActivity;

import dagger.Component;
import dagger.Subcomponent;

@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {

    FragmentComponent providesFragmentComponent(FragmentModule fragmentModule);

    void inject(MainActivity mainActivity);
}
