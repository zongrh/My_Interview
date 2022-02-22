package cn.zong.wanandroid.view

/**
 *
 * FileName: iBaseView
 * Author: nanzong
 * Date: 2022/2/22 4:37 下午
 * Description:
 * History:
 *
 */
interface iBaseView {

    fun loading()

    fun loadComplete()

    fun loadError(msg: String)

}