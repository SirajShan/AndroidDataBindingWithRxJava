package com.shan.databindingrxjava.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.shan.databindingrxjava.R;
import com.shan.databindingrxjava.databinding.ListItemBinding;
import com.shan.databindingrxjava.model.User;
import com.shan.databindingrxjava.viewmodel.ItemViewModel;

import java.util.Collections;
import java.util.List;

/**
 * Created by Sirajuddin on 12/10/2017.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserAdpaterViewHolder> {

    private List<User> userList;

    public UserAdapter() {
        this.userList = Collections.emptyList();
    }

    @Override
    public UserAdpaterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ListItemBinding rootView = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.list_item, parent, false);
        return new UserAdpaterViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(UserAdpaterViewHolder holder, int position) {
      holder.bindUser(userList.get(position));
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class UserAdpaterViewHolder extends RecyclerView.ViewHolder {
        ListItemBinding mItemUserBinding;

        public UserAdpaterViewHolder(ListItemBinding itemUserBinding) {
            super(itemUserBinding.itemPeople);
            this.mItemUserBinding = itemUserBinding;
        }

        void bindUser(User user){
            if(mItemUserBinding.getUserItem() == null){
                mItemUserBinding.setUserItem(new ItemViewModel(user, itemView.getContext()));
            }else {
                mItemUserBinding.getUserItem().setUser(user);
            }
        }
    }
}
