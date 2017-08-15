package com.emrekose.gununozeti.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.emrekose.gununozeti.R;
import com.emrekose.gununozeti.model.entity.Content;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by emrekose on 15.08.2017.
 */

public class SummaryRecyclerAdapter extends RecyclerView.Adapter<SummaryRecyclerAdapter.ViewHolder> {

    Context context;
    List<Content> contentList = new ArrayList<>();

    @Inject
    public SummaryRecyclerAdapter(Context context, List<Content> contentList) {
        this.context = context;
        this.contentList = contentList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.summary_row, parent, false);

        return new ViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Content content = contentList.get(position);
        holder.summaryNumber.setText(String.valueOf(position + 1));
        holder.summaryText.setText(content.getTitle());
    }

    @Override
    public int getItemCount() {
        return contentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.summaryNumber)
        TextView summaryNumber;

        @BindView(R.id.summaryText)
        TextView summaryText;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
