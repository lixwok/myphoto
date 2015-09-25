package myphoto.xlab.wonders.com.myphoto;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
/**
 * Created by lixuanwu on 15/9/15.
 */
public class MyRecyclerView extends RecyclerView {

    /**
     * 记录当前第一个View
     */

    private View mCurrentView;

    /**
     * 滚动时回调的接口
     */
    private OnItemScrollChangeListener onItemScrollChangeListener;


    public interface OnItemScrollChangeListener {
        void onChange(View view, int position);
    }


    public void setOnItemScrollChangeListener(OnItemScrollChangeListener onItemScrollChangeListener) {

        this.onItemScrollChangeListener = onItemScrollChangeListener;
    }

    public MyRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onScrollStateChanged(int arg0) {
    }

    @Override
    public void onScrolled(int dx, int dy) {
        View newView =getChildAt(0);
        if (onItemScrollChangeListener !=null){
            if (newView !=null && newView !=mCurrentView){
                mCurrentView = newView;
                onItemScrollChangeListener.onChange(mCurrentView,getChildPosition(mCurrentView));
            }
        }
    }

    /**
     * 滚动时，判断当前第一个View是否发生变化，发生才回调
     */


    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);

        mCurrentView = getChildAt(0);

        if (onItemScrollChangeListener != null) {

            onItemScrollChangeListener.onChange(mCurrentView, getChildPosition(mCurrentView));
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        if (e.getAction() == MotionEvent.ACTION_MOVE) {

            mCurrentView = getChildAt(0);
            if (onItemScrollChangeListener != null) {
                onItemScrollChangeListener.onChange(mCurrentView, getChildPosition(mCurrentView));
            }
        }
        return super.onTouchEvent(e);
    }

}
