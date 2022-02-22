package cn.my.interview.utils

import android.content.Context
import android.content.Intent

/**
 *
 * FileName: CommonUtils
 * Author: nanzong
 * Date: 2022/2/16 12:15 上午
 * Description:
 * History:
 *
 */

fun activityTiaozhuan(ctx : Context, clz : Class<Any>){
    var intent = Intent()
    intent.setClass(ctx,clz)
    ctx.startActivity(intent)
}
