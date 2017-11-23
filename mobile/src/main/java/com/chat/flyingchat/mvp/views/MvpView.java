package com.chat.flyingchat.mvp.views;

public interface MvpView {
    void showLoading();
    void hideLoading();
    void showError(String error);
}
