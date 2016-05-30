package com.example.anna.postersapp.api;

import com.example.anna.postersapp.postlist.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by anna on 5/20/16.
 */
public interface RemoteApi {

    @GET("users")
    Call<List<User>> getUsers();

    @GET("posts")
    Call<List<Post>> getPosts(@Query("userId") int userId);
}
