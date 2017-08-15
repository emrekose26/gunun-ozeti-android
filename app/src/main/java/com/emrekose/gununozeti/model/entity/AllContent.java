package com.emrekose.gununozeti.model.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by emrekose on 15.08.2017.
 */

public class AllContent {
    @SerializedName("date2")
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
