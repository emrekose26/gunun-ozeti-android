package com.emrekose.gununozeti.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.emrekose.gununozeti.R;
import com.emrekose.gununozeti.model.entity.SummaryResponse;
import com.emrekose.gununozeti.mvp.view.SummaryView;

import dagger.android.AndroidInjection;

public class MainActivity extends AppCompatActivity implements SummaryView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showSummaries(SummaryResponse response) {

    }
}
