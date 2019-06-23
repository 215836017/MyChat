package com.fzq.mychat.ui.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.fzq.mychat.R;
import com.fzq.mychat.ui.MessageDetailsActivity;

public class MsgListAdapter extends RecyclerView.Adapter<MsgListAdapter.ViewHolder> {

    private Context context;
    private String[] friends;
    private Intent toDetailActIntent;
    public final static String BUNDLE_KEY_NAME = "friend_name";

    public MsgListAdapter(Context context, String[] friends) {
        this.context = context;
        this.friends = friends;
        toDetailActIntent = new Intent(context, MessageDetailsActivity.class);
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_msg_list_item, viewGroup, false);
        //这里还可以对Item整体进行属性的设置或事件的监听

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {

        viewHolder.textName.setText(friends[position]);

        //这里可以对Item中具体控件进行属性的设置或事件的监听
        viewHolder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "点击了：" + friends[position], Toast.LENGTH_SHORT).show();
                toDetailActIntent.putExtra(BUNDLE_KEY_NAME, friends[position]);
                context.startActivity(toDetailActIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return friends.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ConstraintLayout layout;
        private TextView textName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            layout = itemView.findViewById(R.id.msgListAct_item_layout);
            textName = itemView.findViewById(R.id.msgListAct_item_text);
        }
    }
}
