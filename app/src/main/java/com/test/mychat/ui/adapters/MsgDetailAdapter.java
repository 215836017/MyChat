package com.test.mychat.ui.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.test.mychat.R;

public class MsgDetailAdapter extends RecyclerView.Adapter<MsgDetailAdapter.ViewHolder> {

    private Context context;
    private String[] friends;

    public MsgDetailAdapter(Context context, String[] friends) {
        this.context = context;
        this.friends = friends;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_msg_detail_item, viewGroup, false);
        //这里还可以对Item整体进行属性的设置或事件的监听

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {

        //  viewHolder.textName.setText(friends[position]);
       if(position % 4 == 0){
           viewHolder.textName.setVisibility(View.VISIBLE);
       }else if (position % 3 == 1) {
            viewHolder.layoutRight.setVisibility(View.VISIBLE);
        } else if (position % 3 == 2) {
            viewHolder.layoutLeftTest.setVisibility(View.VISIBLE);
        } else if (position % 3 == 3) {
            viewHolder.layoutLeft.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public int getItemCount() {
        return friends.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textName;

        private ConstraintLayout layoutLeft;
        private TextView textLeft;

        private ConstraintLayout layoutLeftTest;
        private ImageView imageLeft;

        private ConstraintLayout layoutRight;
        private TextView textRight;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textName = itemView.findViewById(R.id.msgDetailAct_item_time_text);

            layoutLeft = itemView.findViewById(R.id.msgDetailAct_item_left_layout);
            layoutLeftTest = itemView.findViewById(R.id.msgDetailAct_item_left_layoutTest);
            layoutRight = itemView.findViewById(R.id.msgDetailAct_item_right_layout);
        }
    }
}
