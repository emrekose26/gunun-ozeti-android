package com.emrekose.gununozeti.di.main;

import com.emrekose.gununozeti.model.api.ApiSource;
import com.emrekose.gununozeti.mvp.presenter.SummaryPresenter;
import com.emrekose.gununozeti.mvp.presenter.SummaryPresenterImpl;
import com.emrekose.gununozeti.mvp.view.SummaryView;
import com.emrekose.gununozeti.ui.activity.MainActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by emrekose on 15.08.2017.
 */

@Module
public class MainActivityModule {

    @Provides
    SummaryView provideMainView (MainActivity activity) {
        return activity;
    }

    @Provides
    SummaryPresenter provideMainPresenter(SummaryView view, ApiSource apiSource) {
        return new SummaryPresenterImpl(view, apiSource);
    }

}
