package com.chat.flyingchat.mvp.presenters;

import com.chat.flyingchat.mvp.views.MvpView;

public interface MvpPresenter<V extends MvpView> {

    public void attachView(V view);

    public void detachView(boolean retainInstance);
}
