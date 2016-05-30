package com.example.anna.postersapp.details;

import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.anna.postersapp.R;
import com.example.anna.postersapp.api.User;


import org.parceler.Parcels;


/**
 * Created by anna on 5/24/16.
 */
public class DetailsActivity extends AppCompatActivity implements DetailsActivityCallback {
    private User mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);

        mUser = Parcels.unwrap(getIntent().getParcelableExtra(User.USER_KEY));
        setTitle(mUser.getName());

        Fragment fragment = PersonalInfoFragment.newInstance(mUser);
        /*Difference between getFragmentManager() ??????*/
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.details_container, fragment)
                .commit();
    }

    @Override
    public void handleCompanyClick() {
        Fragment fragment = CompanyFragment.newInstance(mUser);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.details_container, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void handleAddressClick() {
        Fragment fragment = AddressFragment.newInstance(mUser);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.details_container, fragment)
                .addToBackStack(null)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit();
    }
}
