package com.emrekose.gununozeti.model.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by emrekose on 15.08.2017.
 */

public class Content {

    @SerializedName("title")
    private String title;

    @SerializedName("url")
    private String url;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
