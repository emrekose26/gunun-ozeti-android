package com.emrekose.gununozeti.model.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by emrekose on 15.08.2017.
 */

public class AllSummaryResponse {
    @SerializedName("0")
    private AllContent allContent;

    public AllContent getAllContent() {
        return allContent;
    }

    public void setAllContent(AllContent allContent) {
        this.allContent = allContent;
    }
}
