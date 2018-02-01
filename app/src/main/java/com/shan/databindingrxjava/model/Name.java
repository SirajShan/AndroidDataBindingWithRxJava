package com.shan.databindingrxjava.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Sirajuddin on 12/10/2017.
 */

public class Name {
    @SerializedName ("title") public String title;

    @SerializedName("first") public String first;

    @SerializedName("last") public String last;


}
