package com.office.retrofitjsonparsing.model.scholoars;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Surah {

    @SerializedName("name_eng")
    @Expose
    private String name_eng;

    @SerializedName("name_ar")
    @Expose
    private String name_ar;

    @SerializedName("total_ayat")
    @Expose
    private String total_ayat;

    public String getName_eng() {
        return name_eng;
    }

    public void setName_eng(String name_eng) {
        this.name_eng = name_eng;
    }

    public String getName_ar() {
        return name_ar;
    }

    public void setName_ar(String name_ar) {
        this.name_ar = name_ar;
    }

    public String getTotal_ayat() {
        return total_ayat;
    }

    public void setTotal_ayat(String total_ayat) {
        this.total_ayat = total_ayat;
    }

    @Override
    public String toString() {
        return "Surah{" +
                "name_eng='" + name_eng + '\'' +
                ", name_ar='" + name_ar + '\'' +
                ", total_ayat='" + total_ayat + '\'' +
                '}';
    }
}
