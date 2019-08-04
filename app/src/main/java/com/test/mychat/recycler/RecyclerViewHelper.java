package com.test.mychat.recycler;

import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;

public class RecyclerViewHelper {

    public static void setVerticalRecyclerViewAttrs(Context context, RecyclerView recyclerView) {

        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(OrientationHelper.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new MyRecyclerViewDecoration(context, OrientationHelper.VERTICAL));

    }

    public static void setHorizontalRecyclerViewAttrs(Context context, RecyclerView recyclerView) {

        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(OrientationHelper.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new MyRecyclerViewDecoration(context, OrientationHelper.HORIZONTAL));

    }
}
