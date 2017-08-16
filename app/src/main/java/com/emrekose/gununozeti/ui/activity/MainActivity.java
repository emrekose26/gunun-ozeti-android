package com.emrekose.gununozeti.ui.activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.emrekose.gununozeti.R;
import com.emrekose.gununozeti.model.entity.AllSummaryResponse;
import com.emrekose.gununozeti.model.entity.Content;
import com.emrekose.gununozeti.model.entity.SummaryResponse;
import com.emrekose.gununozeti.mvp.presenter.SummaryPresenter;
import com.emrekose.gununozeti.mvp.view.SummaryView;
import com.emrekose.gununozeti.ui.adapter.SummaryRecyclerAdapter;
import com.emrekose.gununozeti.utils.NetworkUtil;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.AndroidInjection;

public class MainActivity extends AppCompatActivity implements SummaryView {

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @BindView(R.id.ozetRecyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.summaryDate)
    TextView summaryDate;

    @BindView(R.id.fabChange)
    FloatingActionButton fab;

    @BindView(R.id.connectionErrorLayout)
    LinearLayout connectionErrorLayout;

    @BindView(R.id.noContentErrorLayout)
    LinearLayout noContentErrorLayout;

    @Inject
    SummaryPresenter presenter;

    SummaryRecyclerAdapter adapter;

    private int mYear, mMonth, mDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        if (!NetworkUtil.isAvailable(this)){
            connectionErrorLayout.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
            summaryDate.setVisibility(View.GONE);
        }else {
            connectionErrorLayout.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
            summaryDate.setVisibility(View.VISIBLE);

            presenter.loadAllSummaries();
            fab.setOnClickListener(v -> getDatePickerDialog());
        }
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
        recyclerView.setVisibility(View.VISIBLE);
        summaryDate.setVisibility(View.VISIBLE);
        noContentErrorLayout.setVisibility(View.GONE);

        summaryDate.setText(response.getDate());

        List<Content> contentList = new ArrayList<>(response.getSummaries().values());
        adapter = new SummaryRecyclerAdapter(this, contentList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void showAllSummaries(AllSummaryResponse response) {
        presenter.loadSummaries(response.getAllContent().getDate());
    }

    @Override
    public void showError() {
        noContentErrorLayout.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
        summaryDate.setVisibility(View.GONE);
    }

    @OnClick(R.id.avatarLayout)
    public void avatarOnClick() {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("http://www.twitter.com/HasanYasar"));
        startActivity(i);
    }

    private void getDatePickerDialog() {

        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, (datePicker, year, month, day) -> {
            String responseDate = month < 10 ? year + "-" + "0" + (month + 1) + "-" + day : year + "-" + "0" + (month + 1) + "-" + day;
            presenter.loadSummaries(responseDate);

        }, mYear, mMonth, mDay);

        // disable future days
        datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());

        datePickerDialog.show();
    }
}
