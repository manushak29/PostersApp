package com.example.anna.postersapp.userlist;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.anna.postersapp.R;

import com.example.anna.postersapp.api.User;
;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by anna on 5/20/16.
 */
public class UserHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.name) TextView name;
    @BindView(R.id.username) TextView username;
    @BindView(R.id.users_item) View rootView;

    private RecyclerAdapter.UserItemClickListener mUserItemClickListener;

    public UserHolder(View itemView, RecyclerAdapter.UserItemClickListener userItemClickListener) {
        super(itemView);
        ButterKnife.bind(this, itemView);

        mUserItemClickListener = userItemClickListener;
    }

    public void bindData(final User user){
        name.setText(user.name);
        username.setText(user.username);

        rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUserItemClickListener.onUserItemClicked(user);
            }
        });
    }
}
