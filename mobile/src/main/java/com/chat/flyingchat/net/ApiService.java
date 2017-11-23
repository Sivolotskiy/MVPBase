package com.chat.flyingchat.net;

import com.chat.flyingchat.net.responce.ConversationResponce;
import com.chat.flyingchat.net.responce.Response;


import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface ApiService {

    @GET("/conversations")
    Observable<ConversationResponce> getConversations();

    @GET("/signin")
    Observable<Response> signIn(@Query("login") String login, @Query("password") String password);
}