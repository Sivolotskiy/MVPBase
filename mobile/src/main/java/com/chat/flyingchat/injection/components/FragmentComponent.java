package com.chat.flyingchat.injection.components;

import com.chat.flyingchat.injection.module.FragmentModule;
import com.chat.flyingchat.ui.fragments.ChatListFragment;

import dagger.Subcomponent;

@Subcomponent(modules = FragmentModule.class)
public interface FragmentComponent {

    void inject(ChatListFragment chatListFragment);
}
