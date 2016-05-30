package com.example.anna.postersapp.userlist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.anna.postersapp.R;

import java.util.List;

import com.example.anna.postersapp.api.User;
import com.example.anna.postersapp.userlist.UserHolder;


/**
 * Created by anna on 5/20/16.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<UserHolder> {
    private Context mContext;
    private List<User> mUserList;
    private UserItemClickListener mUserItemClickListener;

    public RecyclerAdapter(List<User> userList, Context context, UserItemClickListener userItemClickListener) {
        mUserList = userList;
        mContext = context;
        mUserItemClickListener = userItemClickListener;
    }

    @Override
    public UserHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.user_list_item, parent, false);
        return new UserHolder(view, mUserItemClickListener);
    }

    @Override
    public void onBindViewHolder(UserHolder holder, int position) {
        holder.bindData(mUserList.get(position));


    }

    @Override
    public int getItemCount() {
        return mUserList.size();
    }


    public interface UserItemClickListener{
        void onUserItemClicked(User user);
    }


}