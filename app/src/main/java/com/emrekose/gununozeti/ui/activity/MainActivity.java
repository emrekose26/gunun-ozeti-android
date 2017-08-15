package com.emrekose.gununozeti.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.emrekose.gununozeti.R;
import com.emrekose.gununozeti.model.entity.Content;
import com.emrekose.gununozeti.model.entity.SummaryResponse;
import com.emrekose.gununozeti.mvp.presenter.SummaryPresenter;
import com.emrekose.gununozeti.mvp.view.SummaryView;
import com.emrekose.gununozeti.ui.adapter.SummaryRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity implements SummaryView {

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @BindView(R.id.ozetRecyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.summaryDate)
    TextView summaryDate;

    @Inject
    SummaryPresenter presenter;

    SummaryRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        presenter.loadSummaries("2017-08-14");
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showSummaries(SummaryResponse response) {
        summaryDate.setText(response.getDate());

        List<Content> contentList = new ArrayList<>(response.getSummaries().values());
        adapter = new SummaryRecyclerAdapter(this, contentList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        for (Content content: response.getSummaries().values()){
            Timber.e(content.getTitle());
            Timber.e(content.getUrl());
        }
    }
}
