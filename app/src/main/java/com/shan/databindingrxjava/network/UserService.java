package com.shan.databindingrxjava.network;

import com.shan.databindingrxjava.model.UserResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by Sirajuddin on 12/10/2017.
 */

public interface UserService {
    @GET
    Observable<UserResponse> fetchUser(@Url String url);
}
