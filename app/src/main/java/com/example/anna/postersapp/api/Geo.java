
package com.example.anna.postersapp.api;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import lombok.Data;

@Generated("org.jsonschema2pojo")
@Data
@Parcel
public class Geo {

    @SerializedName("lat")
    @Expose
    public String lat;
    @SerializedName("lng")
    @Expose
    public String lng;

}
