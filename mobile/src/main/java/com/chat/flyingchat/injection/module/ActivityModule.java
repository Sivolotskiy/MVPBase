package com.chat.flyingchat.injection.module;


import com.chat.flyingchat.ui.activity.BaseActivity;

import java.lang.ref.WeakReference;

import dagger.Module;

@Module
public class ActivityModule {
    private WeakReference<BaseActivity> mActivity;

    public ActivityModule(BaseActivity activity) {
        mActivity = new WeakReference<>(activity);
    }
}
