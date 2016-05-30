
package com.example.anna.postersapp.api;

import javax.annotation.Generated;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.net.HttpURLConnection;

import lombok.Data;

@Generated("org.jsonschema2pojo")
@Data
@Parcel
public class Company {

    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("catchPhrase")
    @Expose
    public String catchPhrase;
    @SerializedName("bs")
    @Expose
    public String bs;

//    void test(){
//        String jsonArray = "";
//
//        JsonArray array = new JsonArray();
//        array.add(jsonArray);
//
//        for (int i = 0; i < array.size(); i++){
//            JsonElement el = array.get(i);
//
//            JsonObject obj = el.getAsJsonObject();
//
//            long userId = obj.get("userId").getAsLong();
//            long id = obj.get("id").getAsLong();
//            String title = obj.get("title").getAsString();
//            String body = obj.get("body").getAsString();
//        }
//    }

}
