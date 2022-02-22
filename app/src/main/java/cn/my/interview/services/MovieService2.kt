package cn.my.interview.services

import android.app.Service
import android.content.Intent
import android.content.ServiceConnection
import android.os.Binder
import android.os.IBinder
import com.blankj.utilcode.util.LogUtils

/**
 *
 * FileName: MovieService
 * Author: nanzong
 * Date: 2022/2/16 12:05 上午
 * Description:
 * History:
 *
 */

class MovieService2 : Service(){

    private val TAG = "MovieService"
    private var movieBinder = MovieService2.MovieBinder(this@MovieService2)

    private var isRun: Boolean = true


    var count: Int = 0
    var movieName: String = ""

    private lateinit var myThread: Thread

    override fun onCreate() {
        super.onCreate()
        LogUtils.i(TAG,"onBind")
        myThread =  object : Thread() {
            override fun run() {
                println("running from Thread: ${Thread.currentThread()}")
                while (isRun){
                    try {
                        Thread.sleep(2000)
                    } catch (e: Exception) {
                    }
                    count++
                    movieName = "复仇者联盟$count"
                    println(movieName)
                }
            }
        }
        myThread.start()

    }
    override fun onBind(p0: Intent?): IBinder {
        // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        LogUtils.i(TAG,"onBind")
        return movieBinder
    }


    class MovieBinder(private val movieService2: MovieService2) : Binder(){
        val TAG = "MovieBinder"
        fun getMovieService() : MovieService2{
            LogUtils.i(TAG,"getMovieService")
            return movieService2
        }
    }

    override fun unbindService(conn: ServiceConnection?) {
        super.unbindService(conn)
        LogUtils.i(TAG,"unbindService")
    }


    override fun onDestroy() {
        super.onDestroy()
        isRun = false
        LogUtils.i(TAG,"onDestroy")
    }

}
