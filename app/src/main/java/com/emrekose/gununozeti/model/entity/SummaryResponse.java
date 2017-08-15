package com.emrekose.gununozeti.model.entity;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

/**
 * Created by emrekose on 15.08.2017.
 */

public class SummaryResponse {
    @SerializedName("summaries")
    private Map<String, Content> summaries;

    @SerializedName("notice")
    private String notice;

    @SerializedName("date")
    private String date;

    public Map<String, Content> getSummaries() {
        return summaries;
    }

    public void setSummaries(Map<String, Content> summaries) {
        this.summaries = summaries;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
