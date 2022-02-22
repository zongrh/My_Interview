package cn.my.interview.view.scrollview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.ScrollView;

/**
 * FileName: RecyclerScrollview
 * Author: nanzong
 * Date: 2022/2/19 11:55 上午
 * Description:   滑动方向相同之以ScrollView和RecycleView为例的内部解决法
 * History:
 */
public class RecyclerScrollview extends ScrollView {

    private int downY;
    private int mTouchSlop;

    public RecyclerScrollview(Context context) {
        super(context);
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public RecyclerScrollview(Context context, AttributeSet attrs) {
        super(context, attrs);
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public RecyclerScrollview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
//        它获得的是触发移动事件的最短距离，如果小于这个距离就不触发移动控件，
//        如viewpager就是用这个距离来判断用户是否翻页
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public RecyclerScrollview(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                downY = (int) ev.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:
                int moveY = (int) ev.getRawY();
                if (Math.abs(moveY - downY) > mTouchSlop) {
                    return true;
                }
                break;

        }
        return super.onInterceptTouchEvent(ev);
    }
}

//注意：RecycleView一定要被嵌套里面
//<!-- descendantFocusability该属性是当一个为view获取焦点时，定义viewGroup和其子控件两者之间的关系。
//        beforeDescendants：viewgroup会优先其子类控件而获取到焦点
//        afterDescendants：viewgroup只有当其子类控件不需要获取焦点时才获取焦点
//        blocksDescendants：viewgroup会覆盖子类控件而直接获得焦点-->
//
//<RelativeLayout
//     android:layout_width="match_parent"
//             android:layout_height="wrap_content"
//             android:descendantFocusability="blocksDescendants">
//<android.support.v7.widget.RecyclerView
//        android:id="@+id/recyclerView"
//        android:layout_width="match_parent"
//        android:layout_height="match_parent"/>
//</RelativeLayout>


