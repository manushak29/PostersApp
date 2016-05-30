package com.example.anna.postersapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;


import com.example.anna.postersapp.api.RemoteFactory;
import com.example.anna.postersapp.api.User;
import com.example.anna.postersapp.userlist.RecyclerAdapter;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements RecyclerAdapter.UserItemClickListener{
    private RecyclerAdapter mAdapter;
    private Context mContext = this;
    private List<User> mUsersList;

    @BindView(R.id.user_list) RecyclerView mRecyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        loadUsersList();

    }

    public void loadUsersList(){
        RemoteFactory.getInstance().getUsers().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                mUsersList = response.body();
                mAdapter = new RecyclerAdapter(mUsersList, mContext, MainActivity.this);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Sorry, request failed.", Toast.LENGTH_LONG).show();
            }
        });
    }


    @Override
    public void onUserItemClicked(User user) {
//        Why if I put this instead of getApplicationContext() the PostActivity is opened instead of
//        MainActivity.
        Intent intent = new Intent(getApplicationContext(), PostsActivity.class);
        intent.putExtra(User.USER_KEY, Parcels.wrap(user));
        startActivity(intent);
    }
}
