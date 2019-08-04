package com.test.mychat.ui.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.test.mychat.R;

public class DiscoverAdapter extends RecyclerView.Adapter<DiscoverAdapter.ViewHolder> {

    private final String TAG = "DiscoverAdapter.java";

    private Context context;
    private LayoutInflater inflater;
    private String[] titles;

    public DiscoverAdapter(Context context, String[] titles) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.titles = titles;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.layout_discover_list_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        if (position == 0) {
            viewHolder.imageMement.setVisibility(View.VISIBLE);
            viewHolder.imageMark.setVisibility(View.VISIBLE);
        } else {
            viewHolder.imageMement.setVisibility(View.GONE);
            viewHolder.imageMark.setVisibility(View.GONE);
        }

        String emptyItem = context.getString(R.string.empty_item);
        if (titles[position].equals(emptyItem)) {
            viewHolder.textEmpty.setVisibility(View.VISIBLE);

            viewHolder.imagePortrait.setVisibility(View.GONE);
            viewHolder.textTitle.setVisibility(View.GONE);
            viewHolder.imageMement.setVisibility(View.GONE);
            viewHolder.imageMark.setVisibility(View.GONE);
            viewHolder.imageRight.setVisibility(View.GONE);
        } else {
            viewHolder.textEmpty.setVisibility(View.GONE);

            viewHolder.imagePortrait.setVisibility(View.VISIBLE);
            viewHolder.textTitle.setVisibility(View.VISIBLE);
            viewHolder.imageMement.setVisibility(View.VISIBLE);
            viewHolder.imageMark.setVisibility(View.VISIBLE);
            viewHolder.imageRight.setVisibility(View.VISIBLE);

            viewHolder.textTitle.setText(titles[position]);
        }

    }

    @Override
    public int getItemCount() {
        return titles.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textEmpty;
        private ImageView imagePortrait;
        private TextView textTitle;
        private ImageView imageMement;
        private ImageView imageMark;
        private ImageView imageRight;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textEmpty = itemView.findViewById(R.id.fragDiscover_text_empty);
            imagePortrait = itemView.findViewById(R.id.fragDiscover_iamge_portrait);
            textTitle = itemView.findViewById(R.id.fragDiscover_text_name);
            imageMement = itemView.findViewById(R.id.fragDiscover_image_NewComment);
            imageMark = itemView.findViewById(R.id.fragDiscover_image_mark);
            imageRight = itemView.findViewById(R.id.fragDiscover_image_right);
        }
    }
}
