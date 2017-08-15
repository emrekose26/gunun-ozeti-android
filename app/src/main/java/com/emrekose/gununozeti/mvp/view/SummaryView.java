package com.emrekose.gununozeti.mvp.view;

import com.emrekose.gununozeti.model.entity.AllSummaryResponse;
import com.emrekose.gununozeti.model.entity.SummaryResponse;

/**
 * Created by emrekose on 15.08.2017.
 */

public interface SummaryView {

    void showLoading();

    void hideLoading();

    void showSummaries(SummaryResponse response);

    void showAllSummaries(AllSummaryResponse response);
}
