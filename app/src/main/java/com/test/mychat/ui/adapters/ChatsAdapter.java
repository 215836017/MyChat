package com.test.mychat.ui.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.test.mychat.R;
import com.test.mychat.ui.activities.MessageDetailsActivity;

public class ChatsAdapter extends RecyclerView.Adapter<ChatsAdapter.ViewHolder> {

    private Context context;
    private String[] friends;
    private Intent toDetailActIntent;
    public final static String BUNDLE_KEY_NAME = "friend_name";

    public ChatsAdapter(Context context, String[] friends) {
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

//        viewHolder.textTitle.setText(friends[position] + "-d-f-a-s-d-f-g-a-s=d-gaew_g-ewgwe_gfsdfsadf");
        viewHolder.textTitle.setText(friends[position] + "是的高温噶尔大富翁变为是是大V深V");
        viewHolder.imageTitle.setImageResource(R.mipmap.ic_launcher_round);
        if (position % 3 == 0) {

            viewHolder.imageMsgCount.setVisibility(View.VISIBLE);
//            viewHolder.imageMsgCount.setImageResource(R.drawable.test_icon_normal);

            viewHolder.imageAction.setVisibility(View.VISIBLE);
//            viewHolder.imageAction.setImageResource(R.drawable.test_icon_selected);


        } else {
            viewHolder.imageMsgCount.setVisibility(View.GONE);

            viewHolder.imageAction.setVisibility(View.GONE);
        }

//        viewHolder.textContent.setText("[" + friends[position] + "]: 1234=5-a0bcdeew_f-w-e-f-wweg-gvbsdfwerfsdvsadf");
        viewHolder.textContent.setText("[" + friends[position] + "]:闻风丧胆噶温哥华北二环压缩的法王噶女是的发送给我");
        viewHolder.textTime.setText(System.currentTimeMillis() + "");
        //这里可以对Item中具体控件进行属性的设置或事件的监听
        viewHolder.rootLayout.setOnClickListener(new View.OnClickListener() {
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

        private ConstraintLayout rootLayout;
        private ImageView imageTitle;
        private ImageView imageMsgCount;
        private TextView textTitle, textContent, textTime;
        private ImageView imageAction;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rootLayout = itemView.findViewById(R.id.fragChats_listItem_layout);
            imageTitle = itemView.findViewById(R.id.fragChats_listItem_image_headPortrait);
            imageMsgCount = itemView.findViewById(R.id.fragChats_listItem_image_msgCount);
            textTitle = itemView.findViewById(R.id.fragChats_listItem_text_title);
            textContent = itemView.findViewById(R.id.fragChats_listItem_text_content);
            textTime = itemView.findViewById(R.id.fragChats_listItem_text_time);
            imageAction = itemView.findViewById(R.id.fragChats_listItem_iamge_action);
        }
    }
}
