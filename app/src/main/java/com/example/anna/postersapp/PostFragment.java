package com.example.anna.postersapp;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.anna.postersapp.api.RemoteFactory;
import com.example.anna.postersapp.api.User;
import com.example.anna.postersapp.postlist.Post;
import com.example.anna.postersapp.postlist.RecyclerAdapter;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by anna on 5/23/16.
 */
public class PostFragment extends Fragment {
    private RecyclerAdapter mAdapter;
    private User mUser;
    @BindView(R.id.post_list) RecyclerView recyclerView;


    public PostFragment(){}

    public static PostFragment newInstance(User user){
        PostFragment fragment = new PostFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(User.USER_KEY, Parcels.wrap(user));
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUser = Parcels.unwrap(getArguments().getParcelable(User.USER_KEY));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.posts_list, container, false);
        ButterKnife.bind(this, view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadPosts(mUser.getId());
    }

    public void loadPosts(int userId) {
/*        If I declare here local variable I cannot assign to it value onResponse.*/
        RemoteFactory.getInstance().getPosts(userId).enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                mAdapter = new RecyclerAdapter(getContext(), response.body());
                recyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Toast.makeText(getContext().getApplicationContext(), "Sorry, request failed.", Toast.LENGTH_LONG).show();
            }
        });
    }
}
