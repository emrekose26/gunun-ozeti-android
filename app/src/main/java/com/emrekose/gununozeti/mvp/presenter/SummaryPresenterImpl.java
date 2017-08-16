package com.emrekose.gununozeti.mvp.presenter;

import com.emrekose.gununozeti.model.api.ApiSource;
import com.emrekose.gununozeti.mvp.view.SummaryView;
import com.emrekose.gununozeti.utils.RxTransformer;

import javax.inject.Inject;

import timber.log.Timber;

/**
 * Created by emrekose on 15.08.2017.
 */

public class SummaryPresenterImpl implements SummaryPresenter {

    private SummaryView view;
    private ApiSource apiSource;

    @Inject
    public SummaryPresenterImpl(SummaryView view, ApiSource apiSource) {
        this.view = view;
        this.apiSource = apiSource;
    }


    @Override
    public void loadSummaries(String date) {
        view.showLoading();

        apiSource.getSummaries(date)
                .compose(RxTransformer.applyIOToMainThreadSchedulers())
                .subscribe(response -> {
                    view.hideLoading();
                    view.showSummaries(response);
                }, e -> {
                    view.showError();
                    Timber.e("loadSummaries: " + e.getMessage());
                });
    }

    @Override
    public void loadAllSummaries() {
        view.showLoading();

        apiSource.getAllSummaries()
                .compose(RxTransformer.applyIOToMainThreadSchedulers())
                .subscribe(response -> {
                    view.hideLoading();
                    view.showAllSummaries(response);
                }, e -> Timber.e("loadAllSummaries:" + e.getMessage()));
    }
}
