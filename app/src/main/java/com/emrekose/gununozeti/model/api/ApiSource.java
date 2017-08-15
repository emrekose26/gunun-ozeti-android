package com.emrekose.gununozeti.model.api;

import com.emrekose.gununozeti.model.entity.AllSummaryResponse;
import com.emrekose.gununozeti.model.entity.SummaryResponse;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by emrekose on 15.08.2017.
 */

public interface ApiSource {

    @GET("?format=json")
    Observable<SummaryResponse> getSummaries(@Query("date") String date);

    @GET("?get=all")
    Observable<AllSummaryResponse> getAllSummaries();
}
