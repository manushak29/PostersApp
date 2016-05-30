package com.example.anna.postersapp.api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by anna on 5/20/16.
 */
public class RemoteFactory {
    private static final String BASE_URL = "http://jsonplaceholder.typicode.com/";
    private static RemoteApi remoteApi;

    public static RemoteApi getInstance(){
        if(remoteApi == null){
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            remoteApi = retrofit.create(RemoteApi.class);
        }
        return remoteApi;
    }
}
