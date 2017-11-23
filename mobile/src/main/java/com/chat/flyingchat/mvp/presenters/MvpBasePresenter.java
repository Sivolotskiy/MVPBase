package com.chat.flyingchat.mvp.presenters;

import android.support.annotation.Nullable;

import com.chat.flyingchat.mvp.views.MvpView;

import java.lang.ref.WeakReference;

public abstract class MvpBasePresenter<V extends MvpView> implements MvpPresenter<V>{
    private WeakReference<V> viewRef;

    @Override
    public void attachView(V view){
        viewRef = new WeakReference<V>(view);
    }

    @Nullable
    public V getView() {
        return viewRef == null ? null : viewRef.get();
    }

    @Override public void detachView(boolean retainInstance) {
        if (viewRef != null) {
            viewRef.clear();
            viewRef = null;
        }
    }
}
