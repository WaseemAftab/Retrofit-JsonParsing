package com.office.retrofitjsonparsing.model.scholoars;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Scholoars {

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("age")
    @Expose
    private String age;

    @SerializedName("surah")
    @Expose
    private ArrayList<Surah> surah;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public ArrayList<Surah> getSurah() {
        return surah;
    }

    public void setSurah(ArrayList<Surah> surah) {
        this.surah = surah;
    }


    @Override
    public String toString() {
        return "Scholoars{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", surah=" + surah +
                '}';
    }
}
