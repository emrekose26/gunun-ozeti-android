package com.emrekose.gununozeti.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.emrekose.gununozeti.R;
import com.emrekose.gununozeti.model.entity.SummaryResponse;
import com.emrekose.gununozeti.mvp.view.SummaryView;

public class MainActivity extends AppCompatActivity implements SummaryView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
