package com.shan.databindingrxjava.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Sirajuddin on 12/10/2017.
 */

public class Location implements Serializable {
    @SerializedName("street") public String street;

    @SerializedName("city") public String city;

    @SerializedName("state") public String state;

    @SerializedName("postcode") public String postcode;

}
