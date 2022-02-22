package cn.zong.wanandroid.presenter

/**
 *
 * FileName: HomePresenter
 * Author: nanzong
 * Date: 2022/2/22 8:34 下午
 * Description:
 * History:
 *
 */
interface HomePresenter {

    fun getBanner()

    fun getHomeList(curPage: Int)

    fun collect(id: Int, position: Int)

    fun cancelCollect(id: Int, position: Int)
}