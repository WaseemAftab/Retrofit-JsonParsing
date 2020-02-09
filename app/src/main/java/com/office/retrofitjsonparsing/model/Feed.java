package com.office.retrofitjsonparsing.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.office.retrofitjsonparsing.model.scholoars.Scholoars;

import java.util.ArrayList;

public class Feed {

    @SerializedName("scholoars")
    @Expose
    private ArrayList<Scholoars> scholoars;

    public ArrayList<Scholoars> getScholoars() {
        return scholoars;
    }

    public void setScholoars(ArrayList<Scholoars> scholoars) {
        this.scholoars = scholoars;
    }

    @Override
    public String toString() {
        return "Feed{" +
                "scholoars=" + scholoars +
                '}';
    }
}
