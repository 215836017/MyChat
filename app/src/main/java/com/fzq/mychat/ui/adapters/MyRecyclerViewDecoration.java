package com.fzq.mychat.ui.adapters;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by fzq on 2017/8/29.
 * 又因为当我们RecyclerView在进行绘制的时候会进行绘制Decoration,
 * 那么会去调用onDraw和onDrawOver方法，那么这边我们其实只要去重写onDraw和getItemOffsets
 * 这两个方法就可以实现啦。然后LayoutManager会进行Item布局的时候，会去调用getItemOffset方法来
 * 计算每个Item的Decoration合适的尺寸
 */

public class MyRecyclerViewDecoration extends RecyclerView.ItemDecoration {

    //采用系统内置的风格的分割线
    private static final int[] attrs=new int[]{android.R.attr.listDivider};
    private Drawable mDivider;
    private int orientation;
    public MyRecyclerViewDecoration(Context context, int orientation) {
        TypedArray typedArray=context.obtainStyledAttributes(attrs);
        mDivider=typedArray.getDrawable(0);
        typedArray.recycle();
        this.orientation=orientation;
    }
    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        drawHDeraction(c,parent);
        drawVDeraction(c,parent);
    }
    /**
     * 绘制水平方向的分割线
     * @param c
     * @param parent
     */
    private void drawHDeraction(Canvas c,RecyclerView parent){
        int left=parent.getPaddingLeft();
        int right=parent.getWidth()-parent.getPaddingRight();
        int childCount=parent.getChildCount();
        for(int i=0;i<childCount;i++){
            View child=parent.getChildAt(i);
            RecyclerView.LayoutParams layoutParams=(RecyclerView.LayoutParams)child.getLayoutParams();
            int top=child.getBottom()+layoutParams.bottomMargin;
            int bottom=top+mDivider.getIntrinsicHeight();
            mDivider.setBounds(left,top,right,bottom);
            mDivider.draw(c);
        }
    }
    /**
     * 绘制垂直方向的分割线
     * @param c
     * @param parent
     */
    private void drawVDeraction(Canvas c,RecyclerView parent){
        int top=parent.getPaddingTop();
        int bottom=parent.getHeight()-parent.getPaddingBottom();
        int childCount=parent.getChildCount();
        for(int i=0;i<childCount;i++){
            View child=parent.getChildAt(i);
            RecyclerView.LayoutParams layoutParams=(RecyclerView.LayoutParams)child.getLayoutParams();
            int left=child.getRight()+layoutParams.rightMargin;
            int right=left+mDivider.getIntrinsicWidth();
            mDivider.setBounds(left,top,right,bottom);
            mDivider.draw(c);
        }
    }
    @Override
    public void getItemOffsets(Rect outRect,View view, RecyclerView parent, RecyclerView.State state) {
        if(OrientationHelper.HORIZONTAL==orientation){
            outRect.set(0, 0,mDivider.getIntrinsicWidth(), 0);
        }else {
            outRect.set(0, 0, 0,mDivider.getIntrinsicHeight());
        }
    }
}
