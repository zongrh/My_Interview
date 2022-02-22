package cn.zong.wanandroid

import android.app.Application
import android.content.Context
import cn.kotlin.wanandroid.utils.Preference

/**
 *
 * FileName: App
 * Author: nanzong
 * Date: 2022/2/22 12:52 下午
 * Description:
 * History:
 *
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        context = this
//        初始化 SharePreference
        Preference.setContext(applicationContext)
    }

    companion object {
        var context: Context? = null
        fun getAppContext(): Context? {
            return context
        }
    }
}