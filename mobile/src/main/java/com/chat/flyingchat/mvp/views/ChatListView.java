package com.chat.flyingchat.mvp.views;


import com.chat.flyingchat.model.Chat;

import java.util.List;

public interface ChatListView extends MvpView{
    void setData(List<Chat> list);
}
