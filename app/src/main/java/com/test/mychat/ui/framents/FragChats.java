package com.test.mychat.ui.framents;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.test.mychat.R;
import com.test.mychat.recycler.RecyclerViewHelper;
import com.test.mychat.ui.adapters.MsgListAdapter;
import com.test.mychat.recycler.MyRecyclerViewDecoration;

public class FragChats extends Fragment {

    private Context context;
    private View rootView;
    private RecyclerView recyclerView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.frag_chats, container, false);
        initViews();
        return rootView;
    }

    private void initViews() {
        String[] friends = getResources().getStringArray(R.array.friends);
        recyclerView = rootView.findViewById(R.id.fragChats_recyclerView);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
//        layoutManager.setOrientation(OrientationHelper.VERTICAL);
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
//        recyclerView.addItemDecoration(new MyRecyclerViewDecoration(context, OrientationHelper.VERTICAL));

        RecyclerViewHelper.setVerticalRecyclerViewAttrs(context, recyclerView);
        MsgListAdapter adapter = new MsgListAdapter(context, friends);
        recyclerView.setAdapter(adapter);
    }
}
