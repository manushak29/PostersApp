package com.example.anna.postersapp.details;


import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.anna.postersapp.R;
import com.example.anna.postersapp.api.User;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by anna on 5/25/16.
 */
public class CompanyFragment extends Fragment {
    @BindView(R.id.company_name_value)
    TextView companyName;
    @BindView(R.id.company_slogan_value)
    TextView slogan;
    @BindView(R.id.business_value)
    TextView business;

    private User mUser;

    public static CompanyFragment newInstance(User user) {
        CompanyFragment companyFragment = new CompanyFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(User.USER_KEY, Parcels.wrap(user));
        companyFragment.setArguments(bundle);
        return companyFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUser = Parcels.unwrap(getArguments().getParcelable(User.USER_KEY));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.company, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setData();
    }

    public void setData(){
        companyName.setText(mUser.getCompany().getName());
        slogan.setText(mUser.getCompany().getCatchPhrase());
        business.setText(mUser.getCompany().getBs());
    }


}
