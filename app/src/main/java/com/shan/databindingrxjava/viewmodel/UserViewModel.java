package com.shan.databindingrxjava.viewmodel;

import android.content.Context;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.support.annotation.NonNull;
import android.view.View;

import com.shan.databindingrxjava.app.AppController;
import com.shan.databindingrxjava.R;
import com.shan.databindingrxjava.util.Constants;
import com.shan.databindingrxjava.model.User;
import com.shan.databindingrxjava.model.UserResponse;
import com.shan.databindingrxjava.network.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Created by Sirajuddin on 12/10/2017.
 */

public class UserViewModel extends Observable {

    public ObservableInt progressBar;
    public ObservableInt userRecycler;
    public ObservableInt userLabel;
    public ObservableField<String> messageLabel;

    private List<User> userList;
    private Context context;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public UserViewModel(@NonNull Context context) {
        this.context = context;
        this.userList = new ArrayList<>();
        progressBar = new ObservableInt(View.GONE);
        userRecycler = new ObservableInt(View.GONE);
        userLabel = new ObservableInt(View.VISIBLE);
        messageLabel = new ObservableField<>(context.getString(R.string.default_message_loading_users));
    }

    private void updateUserDataList(List<User> peoples) {
        userList.addAll(peoples);
        setChanged();
        try {
            notifyObservers();
        }catch(Exception e){
            System.out.println(e.getLocalizedMessage());
        }
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public void initializeViews() {
        userLabel.set(View.GONE);
        userRecycler.set(View.GONE);
        progressBar.set(View.VISIBLE);
    }

    public void onClickFabToLoad(View view) {
        initializeViews();
        fetchUsersList();
    }

    private void fetchUsersList() {
        AppController appController = AppController.create(context);
        UserService usersService = appController.getUserService();

        Disposable disposable = usersService.fetchUser(Constants.RANDOM_USER_URL)
                .subscribeOn(appController.subscribeScheduler())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<UserResponse>() {
                    @Override
                    public void accept(UserResponse userResponse) throws Exception {
                        System.out.println("reached here 3  ");

                        updateUserDataList(userResponse.getPeopleList());
                        System.out.println("reached here 4 ");

                        progressBar.set(View.GONE);
                        userLabel.set(View.GONE);
                        userRecycler.set(View.VISIBLE);
                    }
                }, new Consumer<Throwable>(){

            @Override
            public void accept(Throwable throwable) throws Exception {

            }
        });
        compositeDisposable.add(disposable);
    }


}
