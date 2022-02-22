package cn.my.interview.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import cn.my.interview.R
import com.blankj.utilcode.util.LogUtils
import kotlinx.android.synthetic.main.activity_on_touch.*

class OnTouchActivity : AppCompatActivity(){

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        if (ev != null) {
            if (ev.action == MotionEvent.ACTION_DOWN) {
                LogUtils.i("OnTouchActivity", "activity--> onTouchEvent")
//                return true
            }
        }
        return super.dispatchTouchEvent(ev)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
//        if (event != null) {
//            if (event.action == MotionEvent.ACTION_DOWN) {
//                LogUtils.i("OnTouchActivity", "activity--> onTouchEvent")
////                return true
//            }
//        }
        LogUtils.i("OnTouchActivity", "activity-->  外  onTouchEvent")
        return super.onTouchEvent(event)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_touch)
        my_viewgroup_touch.setOnClickListener {
            LogUtils.i("OnTouchActivity", "my_viewgroup_touch--> onclick")
        }

        my_view_touch.setOnClickListener {
            LogUtils.i("OnTouchActivity", "my_view_touch--> onclick")
        }


    }


}