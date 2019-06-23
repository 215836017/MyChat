package com.fzq.mychat.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;

import com.fzq.mychat.R;
import com.fzq.mychat.ui.adapters.MsgListAdapter;
import com.fzq.mychat.ui.adapters.MyRecyclerViewDecoration;

public class MessageListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private String[] friends;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_list);

        initViews();
    }

    private void initViews() {
        friends = getResources().getStringArray(R.array.friends);

        recyclerView = findViewById(R.id.msgListAct_recyelerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(OrientationHelper.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new MyRecyclerViewDecoration(this, OrientationHelper.VERTICAL));
        MsgListAdapter adapter = new MsgListAdapter(this, friends);
        recyclerView.setAdapter(adapter);
    }
}
