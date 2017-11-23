package com.chat.flyingchat.net;

import android.text.TextUtils;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

@Singleton
public final class OauthInterceptor implements Interceptor {

    private static final String COOKIE_LANG = "user_lang";
    private static final String COOKIE_CURRENCY = "user_currency";
    private static final String COOKIE_GUEST_TOKEN = "messages-guest";

//    private PrefManager mPrefManager;

    //TODO:impl after prefManager
    @Inject
    public OauthInterceptor(/*PrefManager prefManager*/) {
//        mPrefManager = prefManager;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();

        final String token = ""/* mPrefManager.getAccessTokenPref().get()*/;
        final String lang = ""/*mPrefManager.getCurrentLocalePref().get()*/;
        final String guestToken = ""/*mPrefManager.getGuestTokenPref().get()*/;

        if (!TextUtils.isEmpty(token)) {
            builder.header("Authorization", token);
        }

        if (!TextUtils.isEmpty(guestToken)) {
            builder.addHeader(COOKIE_GUEST_TOKEN, guestToken);
        }
        return chain.proceed(builder.build());
    }

    private String addCookie(String currencyAbbr, String cookieCurrency) {
        return String.format("%s=%s;", cookieCurrency, currencyAbbr);
    }
}