
package com.example.anna.postersapp.api;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import lombok.Data;

@Generated("org.jsonschema2pojo")
@Data
@Parcel
public class Address {

    @SerializedName("street")
    @Expose
    public String street;
    @SerializedName("suite")
    @Expose
    public String suite;
    @SerializedName("city")
    @Expose
    public String city;
    @SerializedName("zipcode")
    @Expose
    public String zipcode;
    @SerializedName("geo")
    @Expose
    public Geo geo;

}
