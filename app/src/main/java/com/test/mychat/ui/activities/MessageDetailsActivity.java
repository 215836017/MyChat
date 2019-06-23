package com.test.mychat.ui.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.TextView;

import com.test.mychat.R;
import com.test.mychat.ui.adapters.MsgDetailAdapter;
import com.test.mychat.ui.adapters.MsgListAdapter;

public class MessageDetailsActivity extends AppCompatActivity {

    /*** 界面顶部的人物关系名称：好友名称或者群组名称 */
    private String relationName;

    private TextView textRelationName;
    private RecyclerView recyclerView;

    private String[] testNames;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_details);

        initViews();
    }

    private void initViews() {

        relationName = getIntent().getStringExtra(MsgListAdapter.BUNDLE_KEY_NAME);
        textRelationName = findViewById(R.id.msgDetailAct_text_relationName);
        if (!TextUtils.isEmpty(relationName)) {
            textRelationName.setText(relationName);
        }

        testNames = getResources().getStringArray(R.array.test);
        recyclerView = findViewById(R.id.msgDetailAct_recyelerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(OrientationHelper.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
       // recyclerView.addItemDecoration(new MyRecyclerViewDecoration(this, OrientationHelper.VERTICAL));
        MsgDetailAdapter adapter = new MsgDetailAdapter(this, testNames);
        recyclerView.setAdapter(adapter);
    }
}
