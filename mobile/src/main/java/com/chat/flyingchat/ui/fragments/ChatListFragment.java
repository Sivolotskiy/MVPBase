package com.chat.flyingchat.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chat.flyingchat.R;
import com.chat.flyingchat.model.Chat;
import com.chat.flyingchat.mvp.presenters.ChatListPresenter;
import com.chat.flyingchat.mvp.views.ChatListView;
import com.chat.flyingchat.ui.adapters.ChatListAdapter;
import com.chat.flyingchat.ui.adapters.decorators.ItemListDividerDecorator;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Qualifier;

import butterknife.BindView;

public class ChatListFragment extends BaseFragment<ChatListView, ChatListPresenter>
        implements ChatListView {

    @BindView(R.id.fragment_chat_list_recycler_view)
    RecyclerView mRecyclerView;
    @BindView(R.id.fragment_chat_list_refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    @Inject
    ChatListPresenter mChatListPresenter;

    private ChatListAdapter mAdapter;
    private List<Chat> mChatItems;

    public static ChatListFragment newInstance() {
        return new ChatListFragment();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mChatListPresenter.attachView(this);
        initRecycler();
        loadData();
        mSwipeRefreshLayout.setOnRefreshListener(this::loadData);
    }

    private void initRecycler() {
        mAdapter = new ChatListAdapter(getContext());
        mAdapter.setItems(mChatItems);
        mRecyclerView.addItemDecoration(new ItemListDividerDecorator(getContext(), R.drawable.divider));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mAdapter);
    }

    private void loadData() {
        mChatListPresenter.getChatList();
    }

    @Override
    public int getLayoutRes() {
        return R.layout.fragement_chat_list;
    }

    @Override
    void injectDependencies() {
        getFragmentComponent().inject(this);
    }

    @Override
    public void setData(List<Chat> list) {
        mSwipeRefreshLayout.setRefreshing(false);
        if (list != null) {
            mChatItems = list;
            mAdapter.setItems(mChatItems);
        }
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError(String error) {

    }
}
