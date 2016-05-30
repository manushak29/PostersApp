package com.example.anna.postersapp.details;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.anna.postersapp.R;
import com.example.anna.postersapp.api.User;

import org.parceler.Parcels;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by anna on 5/25/16.
 */
public class AddressFragment extends Fragment {

    @BindView(R.id.address_value)
    TextView street;
    @BindView(R.id.city_value)
    TextView city;
    @BindView(R.id.zipcode_value)
    TextView zipCode;

    private User mUser;

    public AddressFragment() {
        super();
    }

    public static AddressFragment newInstance(User user) {
        AddressFragment addressFragment = new AddressFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(User.USER_KEY, Parcels.wrap(user));
        addressFragment.setArguments(bundle);
        return addressFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUser = Parcels.unwrap(getArguments().getParcelable(User.USER_KEY));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.address, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setData();
    }

    public void setData() {
        street.setText(mUser.getAddress().getStreet());
        city.setText(mUser.getAddress().getCity());
        zipCode.setText(mUser.getAddress().getZipcode());
    }

    @OnClick(R.id.map)
    public void openMap() {
        String latitude = mUser
                .getAddress()
                .getGeo()
                .getLat();

        String longitude = mUser
                .getAddress()
                .getGeo()
                .getLng();
        String coordinates = String.format("geo:0,0?q=%s,%s(label)", latitude, longitude);
        Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse(coordinates) );
        startActivity( intent );
    }
}
