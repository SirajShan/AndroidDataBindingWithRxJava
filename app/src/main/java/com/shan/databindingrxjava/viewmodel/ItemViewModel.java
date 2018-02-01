package com.shan.databindingrxjava.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.shan.databindingrxjava.model.User;

/**
 * Created by Sirajuddin on 12/10/2017.
 */

public class ItemViewModel extends BaseObservable {

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    private User user;
    private Context context;

    public ItemViewModel(User user, Context context) {
        this.user = user;
        this.context = context;
    }

    public String getProfileThumb() {
        return user.picture.medium;
    }

    public String getFullName() {
        user.fullName = user.name.title + "." + user.name.first + " " + user.name.last;
        return user.fullName;
    }

    public String getCell() {
        return user.cell;
    }

    public String getEmail() {
        return user.email;
    }

    public void onItemClick(View v){
        //context.startActivity(UserDetailActivity.fillDetail(v.getContext(), user));
    }

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String url) {
        Glide.with(imageView.getContext()).load(url).into(imageView);
    }
}
