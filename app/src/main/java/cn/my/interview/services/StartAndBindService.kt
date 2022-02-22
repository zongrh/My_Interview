package cn.my.interview.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.os.Looper
import com.blankj.utilcode.util.LogUtils

/**
 *
 * FileName: StartAndBindService
 * Author: nanzong
 * Date: 2022/2/16 12:14 上午
 * Description:
 * History:
 *
 */

//同一个Service，先startService，然后再bindService，如何把它停止掉？
//可以看出先启动，然后在bind，两种启动都会执行，但是如果已这种方式启动之后，
// 调用stopservice，service不会被停止，而调用unbindservice后service才会被停止
// ，
// 由此可见，service由start方式启动，然后在调用bind之后，是先启动，然后在和组件绑定，
// 其实只是一个service，因为onstart方法已被启用，所以看不出来，其实在调用onbind的时候，不会再走onstart方法。


//这个问题可以通过例子来看：新建一个service，并且在清单文件中注册：
class StartAndBindService : Service() {

    val TAG = "StartAndBindService"
    override fun onCreate() {
        super.onCreate()
        if (Looper.getMainLooper() == Looper.myLooper()) {
            LogUtils.i(TAG, "onCreate运行在主线程")
        } else {
            LogUtils.i(TAG, "onCreate运行在子线程")
        }
    }


    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            LogUtils.i(TAG, "onStartCommand运行在主线程")
        } else {
            LogUtils.i(TAG, "onStartCommand运行在子线程")
        }
        return super.onStartCommand(intent, flags, startId)
    }

    //启动service
    override fun onStart(intent: Intent?, startId: Int) {
        super.onStart(intent, startId)
        if (Looper.getMainLooper() == Looper.myLooper()) {
            LogUtils.i(TAG, "onStart运行在主线程")
        } else {
            LogUtils.i(TAG, "onStart运行在子线程")
        }
    }


    //绑定service
    override fun onBind(intent: Intent): IBinder? {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            LogUtils.i(TAG, "onBind运行在主线程")
        } else {
            LogUtils.i(TAG, "onBind运行在子线程")
        }
        return null
    }

    override fun onDestroy() {
        super.onDestroy()
        if (Looper.getMainLooper() == Looper.myLooper()) {
            LogUtils.i(TAG, "onDestroy运行在主线程")
        } else {
            LogUtils.i(TAG, "onDestroy运行在子线程")
        }
    }
}