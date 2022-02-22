package cn.my.interview.view.scrollview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

/**
 * FileName: MyViewPager
 * Author: nanzong
 * Date: 2022/2/18 9:50 下午
 * Description:
 * History:
 */
//滑动方向不同之以ScrollView与ViewPager为例的内部解决法
//从子View着手，父View 先不要拦截任何事件，所有的 事件传递给子View，
// 如果子View需要此事件就消费掉，不需要此事件的话就交给 父View 处理。

//实现思路 如下，重写 子View 的dispatchTouchEvent方法，
// 在Action_down动作中通过方法requestDisallowInterceptTouchEvent（true）
// 先请求 父View 不要拦截事件，这样保证子View能够接受到Action_move事件，
// 再在Action_move动作中根据自己的逻辑是否要拦截事件，不要的话再交给 父View 处理
public class MyViewPager extends ViewPager {
    private static final String TAG = "yc";

    int lastX = -1;
    int lastY = -1;

    public MyViewPager(@NonNull Context context) {
        super(context);
    }

    public MyViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        int x = (int) ev.getRawX();
        int y = (int) ev.getRawY();
        int dealtX = 0;
        int dealtY = 0;
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                dealtX = 0;
                dealtY = 0;
                //保证子View能够接收到Action_move事件
                getParent().requestDisallowInterceptTouchEvent(true);
                break;
            case MotionEvent.ACTION_MOVE:
                dealtX += Math.abs(x - lastX);
                dealtY += Math.abs(y - lastY);
                Log.i(TAG, "dealtX:=" + dealtX);
                Log.i(TAG, "dealtY:=" + dealtY);
                // 这里是够拦截的判断依据是左右滑动，使用者可根据自己的逻辑进行是否拦截
                if (dealtX >= dealtY) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                } else {
                    getParent().requestDisallowInterceptTouchEvent(false);
                }
                break;
            case MotionEvent.ACTION_CANCEL:
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return super.dispatchTouchEvent(ev);
    }
}