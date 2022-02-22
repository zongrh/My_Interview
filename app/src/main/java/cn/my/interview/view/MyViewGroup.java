package cn.my.interview.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.blankj.utilcode.util.LogUtils;

/**
 * FileName: MyViewGroup
 * Author: nanzong
 * Date: 2022/2/18 4:21 上午
 * Description:
 * viewGroup事件分发--》dispatchTouchEvent-->onInterceptTouchEvent-->onTouchEvent-->onclick
 * History:
 */
public class MyViewGroup extends RelativeLayout {

    public MyViewGroup(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            LogUtils.i("MyViewGroup", "MyViewGroup--> dispatchTouchEvent");
        }
//        if (onInterceptTouchEvent(ev)) {
//            LogUtils.i("MyViewGroup", "MyViewGroup--> dispatchTouchEvent--> onInterceptTouchEvent(ev)");
//    }

        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            LogUtils.i("MyViewGroup", "MyViewGroup--> onInterceptTouchEvent");
        }
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            LogUtils.i("MyViewGroup", "MyViewGroup--> onTouchEvent");
        }
        return super.onTouchEvent(event);
    }


}
