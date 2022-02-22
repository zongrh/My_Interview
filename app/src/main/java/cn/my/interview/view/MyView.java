package cn.my.interview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;

/**
 * FileName: MyView
 * Author: nanzong
 * Date: 2022/2/18 4:58 上午
 * Description:
 * History:
 */
public class MyView extends android.support.v7.widget.AppCompatTextView  {

    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            LogUtils.i("MyView", "MyView--> dispatchTouchEvent");
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            LogUtils.i("MyView", "MyView--> onTouchEvent");
        }
        return super.onTouchEvent(event);
    }


}