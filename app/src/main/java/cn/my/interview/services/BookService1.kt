package cn.my.interview.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.blankj.utilcode.util.LogUtils

/**
 *
 * FileName: BookService
 * Author: nanzong
 * Date: 2022/2/16 12:16 上午
 * Description:
 * History:
 *
 */

//service创建及使用（启动状态）
//启动状态：
//如果一个service是通过startService() 方式启动的，
//服务当前的状态即为“启动”状态。一旦启动，服务即可在后台长期运行，
//急事启动该服务的组件已经被销毁，也无任何影响，因为服务此时不依赖任何组件，是独立运行的，
//除非手动调用停止或者强行停止运行应用才能停止服务，已启动的服务通常是执行单一操作，而且不会把结果返回给调用方。
class BookService1 : Service() {

    val TAG = "BookService"
    override fun onBind(intent: Intent): IBinder? {
        LogUtils.i(TAG,"onBind")
        return null
    }

    override fun onCreate() {
        super.onCreate()
        LogUtils.i(TAG,"onCreate")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        LogUtils.i(TAG,"onStartCommand")
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        LogUtils.i(TAG,"onDestroy")
    }
}