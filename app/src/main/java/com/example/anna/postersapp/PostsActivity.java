package com.example.anna.postersapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
;import com.example.anna.postersapp.api.User;
import com.example.anna.postersapp.details.DetailsActivity;
import com.example.anna.postersapp.userlist.ViewPagerAdapter;

import org.parceler.Parcels;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by anna on 5/23/16.
 */
public class PostsActivity extends AppCompatActivity {
    @BindView(R.id.tab_layout) TabLayout mTabLayout;
    @BindView(R.id.view_pager) ViewPager mViewPager;
    private User mUser;

    private ViewPagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.posts_todos);
        ButterKnife.bind(this);
        mUser = Parcels.unwrap(getIntent().getParcelableExtra(User.USER_KEY));
        setTitle(mUser.getName());
        initViewPager(mUser);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_details, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId() == R.id.details){
            Intent intent = new Intent(this, DetailsActivity.class);
            intent.putExtra(User.USER_KEY, Parcels.wrap(mUser));
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    private void initViewPager(User user){
        mAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        mAdapter.addFragment(PostFragment.newInstance(user), "Posts");
        mAdapter.addFragment(TodoFragment.newInstance(user), "Todos");
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

}
