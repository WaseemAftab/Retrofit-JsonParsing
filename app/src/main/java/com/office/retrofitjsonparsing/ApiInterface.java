package com.office.retrofitjsonparsing;

import com.office.retrofitjsonparsing.model.Feed;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface ApiInterface {

    String BASE_URL = "http://www.bhimsoft.com/";

    @Headers("Content-Type: application/json")
    @GET("alquran/data/quran.json")
    Call<Feed> getData();
}
