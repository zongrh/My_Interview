package cn.my.interview.ui.activity

import android.app.Service
import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.*
import android.support.v7.app.AppCompatActivity
import android.util.Log
import cn.my.interview.R
import cn.my.interview.services.*
import com.blankj.utilcode.util.LogUtils
import kotlinx.android.synthetic.main.activity_service.*

private val TAG = "ServiceActivity"


val RECEIVE_MESSAGE_CODE: Int = 0x0002

//客户端的消息处理
class ClientHndler : Handler() {
    override fun handleMessage(msg: Message?) {
        super.handleMessage(msg)
        LogUtils.i(TAG, "clientHndler")
        when (msg?.what) {
            RECEIVE_MESSAGE_CODE -> {
                LogUtils.i(TAG, "这是来自服务端的问候：" + msg.obj)
            }
            else -> {
                LogUtils.i(TAG, "未接收到服务端的问候！！！")
            }
        }
    }
}

//初始化客户端的messenger
val clientMessenger = Messenger(ClientHndler())

class ServiceActivity : AppCompatActivity(), ServiceConnection {


    override fun onServiceDisconnected(name: ComponentName?) {
        LogUtils.i(TAG, "onServiceDisconnected")
    }

    private lateinit var mMovieService2: MovieService2

    override fun onServiceConnected(p0: ComponentName?, p1: IBinder?) {
        LogUtils.i(TAG, "onServiceConnected")
        var movieBinder = p1 as MovieService2.MovieBinder
        mMovieService2 = movieBinder.getMovieService()
    }

    class Conn : ServiceConnection {
        val TAG = "Conn"
        override fun onServiceDisconnected(p0: ComponentName?) {
            LogUtils.i(TAG, "onServiceDisconnected")
        }

        lateinit var serviceMessenger: Messenger

        override fun onServiceConnected(p0: ComponentName?, p1: IBinder?) {
            LogUtils.i(TAG, "onServiceConnected")
            serviceMessenger = Messenger(p1)
        }
    }


    val conn = Conn()

    private var bookbinders = Intent()
    private var movieBinders = Intent()
    private var sbStart = Intent()
    private var sbBind = Intent()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)
        LogUtils.i(TAG, "onCreate")

//        LogUtils.i(TAG,"--service创建及使用（启动状态）------------------------------------------")
        //直接启动service
        btn_start.setOnClickListener {
            bookbinders.setClass(this, BookService1().javaClass)
            startService(bookbinders)
            Log.e("MainMain", "直接启动service------>startService")
        }
        //停止service
        btn_stop.setOnClickListener {
            stopService(bookbinders)
            Log.e("MainMain", "停止service------>stopService")
        }
//        LogUtils.i(TAG,"--service创建及使用（启动状态）------------------------------------------")
        //先启动service
        btn_sb_start.setOnClickListener {
            sbStart.setClass(this@ServiceActivity, StartAndBindService::class.java)
            startService(sbStart)
            Log.e("MainMain", "先启动service------>startService")
        }

        //停止service
        btn_sb_stop.setOnClickListener {
            stopService(sbStart)
            Log.e(
                "StartAndBindService",
                "停止service"
            )
            Log.e("MainMain", "停止service------>stopService")
        }


//        LogUtils.i(TAG,"---service创建及使用（绑定状态）-----------------------------------------")
        //再绑定service
        btn_sb_bind.setOnClickListener {
            bindService(
                Intent(this@ServiceActivity, StartAndBindService::class.java),
                conn,
                Service.BIND_AUTO_CREATE
            )
            Log.e("MainMain", "再绑定service------>bindService")
        }

        //取消绑定service
        btn_sb_unbind.setOnClickListener {
            unbindService(conn)
            Log.e("MainMain", "取消绑定service------>unbindService")
        }

//        LogUtils.i(TAG,"---service创建及使用（绑定状态）-----------------------------------------")
        //绑定service
        btn_bind.setOnClickListener {
            movieBinders.setClass(this, MovieService2::class.java)
            bindService(movieBinders, this, Service.BIND_AUTO_CREATE)
            Log.e("MainMain", "绑定service------>bindService")
        }
        //解除绑定
        btn_unbind.setOnClickListener {
            unbindService(this)
            Log.e("MainMain", "解除绑定------>unbindService")
        }


//        LogUtils.i(TAG,"--------------------------------------------")
        //获取数据
        btn_getdata.setOnClickListener {
            val count = mMovieService2.movieName
            println("从service获取的count===$count")
            Log.e("MainMain", "获取数据------>获取数据:  "+count)
        }

        //msg  bind
        btn_msg_bind.setOnClickListener {
            var intent = Intent()
            intent.setClass(this@ServiceActivity, MusicService::class.java)
            bindService(intent, conn, Service.BIND_AUTO_CREATE)
            Log.e("MainMain", "绑定消息------>bindService")
        }
        //给service发送消息
        btn_send_msg.setOnClickListener {
            val message = Message.obtain(null, SEND_MESSAGE_CODE, 0, 0)
            message.obj = "来自客户端的问候！！！"
            message.replyTo = clientMessenger
            conn.serviceMessenger.send(message)
            Log.e("MainMain", "给service发送消息------>message : "+message.toString())
        }
        //取消绑定
        btn_msg_unbind.setOnClickListener {
            unbindService(conn)
            Log.e("MainMain", "取消绑定------>unbindService")
        }


    }


    override fun onStart() {
        super.onStart()
        LogUtils.i(TAG, "onStart")
    }

    override fun onRestart() {
        super.onRestart()
        LogUtils.i(TAG, "onRestart")
    }

    override fun onResume() {
        super.onResume()
        LogUtils.i(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        LogUtils.i(TAG, "onPause")
    }

    override fun onDestroy() {
        super.onDestroy()
        LogUtils.i(TAG, "onDestroy")
    }


}