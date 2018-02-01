package com.shan.databindingrxjava.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Sirajuddin on 12/10/2017.
 */

public class Picture implements Serializable {
    @SerializedName("large") public String large;

    @SerializedName("medium") public String medium;

    @SerializedName("thumbnail") public String thumbnail;

}
