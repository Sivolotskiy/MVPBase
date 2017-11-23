package com.chat.flyingchat.mvp.presenters;

import com.chat.flyingchat.database.DatabaseManager;
import com.chat.flyingchat.model.Chat;
import com.chat.flyingchat.model.Message;
import com.chat.flyingchat.mvp.views.ChatListView;
import com.chat.flyingchat.net.ApiManager;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class ChatListPresenter extends MvpBasePresenter<ChatListView> {

    @Inject
    DatabaseManager mDatabaseManager;
    ApiManager mApiManager;

    @Inject
    public ChatListPresenter(
            ApiManager apiManager) {
        mApiManager = apiManager;
    }

    public void getChatList() {
        mApiManager.getConversations().subscribe(conversationResponse -> {
                    if (getView() != null) {
                        getView().setData(conversationResponse.getConversations());
                    }
                }, Throwable::printStackTrace);
    }

}
