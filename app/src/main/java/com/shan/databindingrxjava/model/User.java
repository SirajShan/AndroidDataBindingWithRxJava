package com.shan.databindingrxjava.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Sirajuddin on 12/10/2017.
 */

public class User implements Serializable {
    @SerializedName("gender") public String gender;

    @SerializedName("name") public Name name;

    @SerializedName("location") public Location location;

    @SerializedName("email") public String email;

    @SerializedName("login") public Login login;

    @SerializedName("phone") public String phone;

    @SerializedName("cell") public String cell;

    @SerializedName("picture") public Picture picture;

    public String fullName;

    public boolean hasEmail() {return email != null && !email.isEmpty();}

}
