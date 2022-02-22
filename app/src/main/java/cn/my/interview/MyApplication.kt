package cn.my.interview

import android.app.Application
import com.blankj.utilcode.util.Utils

/**
 *
 * FileName: MyApplication
 * Author: nanzong
 * Date: 2022/2/16 12:19 上午
 * Description:
 * History:
 *
 */

class MyApplication : Application(){

    override fun onCreate() {
        super.onCreate()
        Utils.init(this)
    }
}
