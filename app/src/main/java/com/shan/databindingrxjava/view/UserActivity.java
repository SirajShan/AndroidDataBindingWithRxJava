package com.shan.databindingrxjava.view;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.shan.databindingrxjava.R;
import com.shan.databindingrxjava.adapter.UserAdapter;
import com.shan.databindingrxjava.databinding.MainActivityBinding;
import com.shan.databindingrxjava.viewmodel.UserViewModel;

import java.util.Observable;
import java.util.Observer;


public class UserActivity extends AppCompatActivity implements Observer{

    MainActivityBinding userBinding;
    private UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDataBinding();
        setSupportActionBar(userBinding.toolbar);
        setListOfUserView(userBinding.listUser);
        setUpObServer(userViewModel);
    }

    private void initDataBinding() {
        userBinding = DataBindingUtil.setContentView(this, R.layout.main_activity);
        userViewModel = new UserViewModel(this);
        userBinding.setUser(userViewModel);
    }

    private void setListOfUserView(RecyclerView recyclerView){
        UserAdapter userAdapter = new UserAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(userAdapter);

    }

    private void setUpObServer(Observable observable){
       observable.addObserver(this);
    }

    @Override
    public void update(Observable observable, Object o) {
     if(observable instanceof  UserViewModel){
         UserAdapter adapter = (UserAdapter) userBinding.listUser.getAdapter();
         UserViewModel userViewModel = (UserViewModel) o;
         adapter.setUserList(userViewModel.getUserList());
     }
    }
}
