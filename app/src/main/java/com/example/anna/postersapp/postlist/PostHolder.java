package com.example.anna.postersapp.postlist;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.anna.postersapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by anna on 5/24/16.
 */
public class PostHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.post_title)
    TextView title;
    @BindView(R.id.post_body)
    TextView body;

    public PostHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bindData(Post post) {
        title.setText(post.getTitle());
        body.setText(post.getBody());
    }
}
