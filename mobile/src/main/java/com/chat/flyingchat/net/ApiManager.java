package com.chat.flyingchat.net;

import android.content.Context;

import com.chat.flyingchat.net.responce.ConversationResponce;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Response;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ApiManager {

    private static final String TAG = ApiManager.class.getSimpleName();
    private Context mContext;
    private ApiService mApiService;

    @Inject
    public ApiManager(Context context, ApiService apiService) {
        mContext = context;
        mApiService = apiService;
    }

    private <T extends Response> Observable.Transformer<T, T> applyTransformers() {
        return observable -> observable
                .compose(applySchedulers())
                .compose(applyErrorChecker());
    }

    private <T> Observable.Transformer<T, T> applySchedulers() {
        return observable -> observable
                .unsubscribeOn(Schedulers.newThread())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    private <T extends Response> Observable.Transformer<T, T> applyErrorChecker() {
        return observable -> observable.first(t -> {
            if (!t.isSuccessful()) {
//                handleApiError(t.errorBody());  //TODO: add handle
            }
            return true;
        });
    }

    public Observable<ConversationResponce> getConversations() {
        return mApiService.getConversations()
                .compose(applySchedulers());
    }
}
