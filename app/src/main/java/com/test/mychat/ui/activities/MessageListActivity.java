package com.test.mychat.ui.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.test.mychat.R;
import com.test.mychat.ui.adapters.MyFragmentPagerAdapter;
import com.test.mychat.ui.framents.FragChats;
import com.test.mychat.ui.framents.FragConstacts;
import com.test.mychat.ui.framents.FragDiscover;
import com.test.mychat.ui.framents.FragMe;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.mvnjar.com/
 * <p>
 * 在组件化开发中library中如何使用butterknife -- https://www.jianshu.com/p/c6e3f67e391e
 */
public class MessageListActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager viewPager;
    private LinearLayout layoutChats, layoutConstacts, layoutDiscover, layoutMe;
    private ImageView imageChats, imageConstacts, imageDiscover, imageMe;
    private TextView textChats, textConstacts, textDiscover, textMe;

    private ImageView[] bottomImageViews = new ImageView[4];
    private TextView[] bottomTextViews = new TextView[4];
    private final int INDEX_CHATS = 0;
    private final int INDEX_CONSTACTS = 1;
    private final int INDEX_DISCOVER = 2;
    private final int INDEX_ME = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_message_list);

        initViews();
        initDatas();
        setListeners();
    }

    private void initViews() {
        viewPager = findViewById(R.id.msgListAct_viewPager);
        // 底部状态栏
        layoutChats = findViewById(R.id.msgListAct_layout_chats);
        layoutConstacts = findViewById(R.id.msgListAct_layout_contacts);
        layoutDiscover = findViewById(R.id.msgListAct_layout_discover);
        layoutMe = findViewById(R.id.msgListAct_layout_me);
        imageChats = findViewById(R.id.msgListAct_image_chats);
        imageConstacts = findViewById(R.id.msgListAct_image_contacts);
        imageDiscover = findViewById(R.id.msgListAct_image_discover);
        imageMe = findViewById(R.id.msgListAct_image_me);
        textChats = findViewById(R.id.msgListAct_text_chats);
        textConstacts = findViewById(R.id.msgListAct_text_contacts);
        textDiscover = findViewById(R.id.msgListAct_text_discover);
        textMe = findViewById(R.id.msgListAct_text_me);

        bottomImageViews[INDEX_CHATS] = imageChats;
        bottomImageViews[INDEX_CONSTACTS] = imageConstacts;
        bottomImageViews[INDEX_DISCOVER] = imageDiscover;
        bottomImageViews[INDEX_ME] = imageMe;

        bottomTextViews[INDEX_CHATS] = textChats;
        bottomTextViews[INDEX_CONSTACTS] = textConstacts;
        bottomTextViews[INDEX_DISCOVER] = textDiscover;
        bottomTextViews[INDEX_ME] = textMe;

        updateBottomView(INDEX_CHATS);
    }

    private void initDatas() {
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new FragChats());
        fragmentList.add(new FragConstacts());
        fragmentList.add(new FragDiscover());
        fragmentList.add(new FragMe());
        MyFragmentPagerAdapter fragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(),
                fragmentList);
        viewPager.setAdapter(fragmentPagerAdapter);
    }

    private void setListeners() {

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                updateBottomView(i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        layoutChats.setOnClickListener(this);
        layoutConstacts.setOnClickListener(this);
        layoutDiscover.setOnClickListener(this);
        layoutMe.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.msgListAct_layout_chats:
                viewPager.setCurrentItem(INDEX_CHATS);
                updateBottomView(INDEX_CHATS);
                break;

            case R.id.msgListAct_layout_contacts:
                viewPager.setCurrentItem(INDEX_CONSTACTS);
                updateBottomView(INDEX_CONSTACTS);
                break;

            case R.id.msgListAct_layout_discover:
                viewPager.setCurrentItem(INDEX_DISCOVER);
                updateBottomView(INDEX_DISCOVER);
                break;

            case R.id.msgListAct_layout_me:
                viewPager.setCurrentItem(INDEX_ME);
                updateBottomView(INDEX_ME);
                break;
        }
    }

    private void updateBottomView(int index) {
        for (int i = 0; i < bottomImageViews.length; i++) {
            if (i == index) {
                bottomImageViews[i].setSelected(true);
                bottomTextViews[i].setSelected(true);
            } else {
                bottomImageViews[i].setSelected(false);
                bottomTextViews[i].setSelected(false);
            }
        }
    }


}
