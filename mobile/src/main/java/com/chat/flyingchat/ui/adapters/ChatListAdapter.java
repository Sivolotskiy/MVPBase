package com.chat.flyingchat.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chat.flyingchat.R;
import com.chat.flyingchat.interfaces.OnAdapterClickListener;
import com.chat.flyingchat.model.Chat;

import java.util.List;

public class ChatListAdapter extends RecyclerView.Adapter<ChatListAdapter.ViewHolder> {

    private Context mContext;
    private List<Chat> mItems;
    private OnAdapterClickListener mListener;

    public ChatListAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setItems(List<Chat> mItems) {
        this.mItems = mItems;
        notifyDataSetChanged();
    }

    public void setListener(OnAdapterClickListener mListener) {
        this.mListener = mListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ChatListAdapter.ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_chat, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Chat currentItem = mItems.get(position);
        holder.nameTextView.setText(currentItem.getName());
        holder.messageTextView.setText(currentItem.getLastMessage().getText());

        Glide.with(mContext)
                .load(currentItem.getAvatar())
                .into(holder.userImageView);

    }

    @Override
    public int getItemCount() {
        return mItems != null ? mItems.size() : 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView userImageView;
        private final TextView nameTextView;
        private final TextView messageTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            userImageView = (ImageView) itemView.findViewById(R.id.item_chat_image_view);
            nameTextView = (TextView) itemView.findViewById(R.id.item_chat_name_text_view);
            messageTextView = (TextView) itemView.findViewById(R.id.item_chat_message_text_view);
        }
    }
}
