package com.example.anna.postersapp.details;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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
import butterknife.OnClick;

/**
 * Created by anna on 5/25/16.
 */
public class PersonalInfoFragment extends Fragment {

    @BindView(R.id.username_value)
    TextView username;
    @BindView(R.id.email_value)
    TextView email;
    @BindView(R.id.phone_value)
    TextView phone;
    @BindView(R.id.website_value)
    TextView website;

    private DetailsActivityCallback activityCallback;

    private User mUser;


    public static PersonalInfoFragment newInstance(User user) {
        PersonalInfoFragment fragment = new PersonalInfoFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(User.USER_KEY, Parcels.wrap(user));
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            activityCallback = (DetailsActivityCallback) context;
        } catch (ClassCastException e) {
            throw new ClassCastException("Must implement DetailsActivityCallback");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUser = Parcels.unwrap(getArguments().getParcelable(User.USER_KEY));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.personal_data, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setData();
    }

    @OnClick(R.id.open_company)
    public void openCompany() {
        activityCallback.handleCompanyClick();
    }

    @OnClick(R.id.open_address)
    public void openAddress() {
        activityCallback.handleAddressClick();
    }

    public void setData() {
        username.setText(mUser.getUsername());
        email.setText(mUser.getEmail());
        phone.setText(mUser.getPhone());
        website.setText(mUser.getWebsite());
    }

    @OnClick(R.id.email)
    public void openEmailComposer() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        String[] recipients = {};
        intent.putExtra(Intent.EXTRA_EMAIL, recipients);
        intent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
        intent.putExtra(Intent.EXTRA_TEXT, "Text");
        intent.putExtra(Intent.EXTRA_CC, "CC email");
        intent.setType("text/plain");
        startActivity(Intent.createChooser(intent, "Send mail"));
    }

    @OnClick(R.id.phone)
    public void makeCall(){
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + Uri.encode(mUser.getPhone()
                .replaceAll("[-+.^:,x*]",""))));
        startActivity(intent);
    }

    @OnClick(R.id.website)
    public void openWebsite(){
        String url = mUser.getWebsite();
        if (!url.startsWith("http://") && !url.startsWith("https://")){
            url = "http://www." + url;
        }
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}
