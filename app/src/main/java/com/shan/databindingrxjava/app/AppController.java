package com.shan.databindingrxjava.app;

import android.app.Application;
import android.content.Context;

import com.shan.databindingrxjava.network.ApiFactory;
import com.shan.databindingrxjava.network.UserService;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Sirajuddin on 12/10/2017.
 */

public class AppController extends Application {

    private UserService usersService;
    private Scheduler scheduler;

    public static AppController get(Context context) {
        return (AppController) context.getApplicationContext();

    }

    public static AppController create(Context context) {
        return AppController.get(context);
    }

    public UserService getUserService() {
        if (usersService == null) {
            usersService = ApiFactory.create();
        }

        return usersService;
    }

    public UserService getUsersService() {
        return usersService;
    }

    public void setUsersService(UserService usersService) {
        this.usersService = usersService;
    }

    public Scheduler getScheduler() {
        return scheduler;
    }

    public void setScheduler(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    public Scheduler subscribeScheduler() {
        if (scheduler == null) {
            scheduler = Schedulers.io();
        }

        return scheduler;
    }
}
