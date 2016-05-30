
package com.example.anna.postersapp.api;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import lombok.Data;

@Generated("org.jsonschema2pojo")
@Data
@Parcel
public class User {

    public static final String USER_KEY = "com.example.anna.postersapp.api.User";

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("username")
    @Expose
    public String username;
    @SerializedName("email")
    @Expose
    public String email;
    @SerializedName("address")
    @Expose
    public Address address;
    @SerializedName("phone")
    @Expose
    public String phone;
    @SerializedName("website")
    @Expose
    public String website;
    @SerializedName("company")
    @Expose
    public Company company;

}
