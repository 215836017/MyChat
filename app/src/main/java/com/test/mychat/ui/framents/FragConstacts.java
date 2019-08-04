package com.test.mychat.ui.framents;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.test.mychat.R;
import com.test.mychat.databean.ContactsBean;
import com.test.mychat.recycler.RecyclerViewHelper;
import com.test.mychat.ui.adapters.ConstantsAdapter;

import java.util.ArrayList;
import java.util.List;

public class FragConstacts extends Fragment {

    private final String TAG = "FragConstacts.java";
    private Context context;
    private List<ContactsBean> constactBeanList = new ArrayList<>();

    private View rootView;
    private RecyclerView recyclerView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();

        initDatas();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.frag_constants, container, false);

        initViews();
        return rootView;
    }

    private void initDatas() {
//        constactBeanList.add(new ContactsBean());
    }

    private void initViews() {
        recyclerView = rootView.findViewById(R.id.fragConstants_recyclerView);
        RecyclerViewHelper.setVerticalRecyclerViewAttrs(context, recyclerView);
        ConstantsAdapter adapter = new ConstantsAdapter(context, constactBeanList);
        recyclerView.setAdapter(adapter);
    }


}
