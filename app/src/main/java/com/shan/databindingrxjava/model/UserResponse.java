package com.shan.databindingrxjava.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Sirajuddin on 12/10/2017.
 */

public class UserResponse {

    @SerializedName("results") private List<User> userList;

    public List<User> getPeopleList () { return userList;}

    public void setPeopleList(List<User> mUserList) { this.userList = mUserList ;}

}
