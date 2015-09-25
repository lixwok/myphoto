package com.xlab.wonders.fullway.widget;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by lixuanwu on 15/9/23.
 */
public class MyRecyclerView extends RecyclerView {

    /**
     * 记录当前第一个View
     */
    private View mCurrentView;

    public interface onItemScrollChangeListener {
        void onChange(View v, int position);
    }

    private onItemScrollChangeListener mOnItemScrollChangeListener;

    public void setmOnItemScrollChangeListener(onItemScrollChangeListener mOnItemScrollChangeListener) {
        this.mOnItemScrollChangeListener = mOnItemScrollChangeListener;
    }

    public MyRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        mCurrentView = getChildAt(0);
        if (mOnItemScrollChangeListener != null) {

            mOnItemScrollChangeListener.onChange(mCurrentView, getChildAdapterPosition(mCurrentView));
        }
    }

    @Override
    public void onScrollStateChanged(int state) {
        super.onScrollStateChanged(state);
    }

    /**
     * 滚动时，判断当前第一个View是否发生变化，发生才回调
     */
    @Override
    public void onScrolled(int dx, int dy) {

        View newView = getChildAt(0);
        if (mOnItemScrollChangeListener != null) {
            if (newView != null && newView != mCurrentView) {
                mCurrentView = newView;
                mOnItemScrollChangeListener.onChange(mCurrentView, getChildAdapterPosition(mCurrentView));
            }
        }
    }
}
