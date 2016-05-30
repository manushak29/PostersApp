package com.example.anna.postersapp.postlist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.anna.postersapp.R;

import java.util.List;

/**
 * Created by anna on 5/24/16.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<PostHolder>{
    private Context mContext;
    private List<Post> mPostList;

    public RecyclerAdapter(Context context, List<Post> postList) {
        mContext = context;
        mPostList = postList;
    }

    @Override
    public PostHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.posts_list_item, parent, false);
        return new PostHolder(view);
    }

    @Override
    public void onBindViewHolder(PostHolder holder, int position) {
        holder.bindData(mPostList.get(position));
    }

    @Override
    public int getItemCount() {
        return mPostList.size();
    }
}
