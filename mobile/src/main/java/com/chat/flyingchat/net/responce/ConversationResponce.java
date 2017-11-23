package com.chat.flyingchat.net.responce;


import com.chat.flyingchat.model.Chat;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import lombok.Data;

public class ConversationResponce extends Response {

    @SerializedName("conversations")
    private ArrayList<Chat> conversations;


    public ArrayList<Chat> getConversations() {
        return conversations;
    }
}
