package cn.zong.wanandroid.view

import cn.zong.wanandroid.bean.BannerBean
import cn.zong.wanandroid.bean.HomeListBean

/**
 *
 * FileName: HomeView
 * Author: nanzong
 * Date: 2022/2/22 8:33 下午
 * Description:
 * History:
 *
 */
interface HomeView : iBaseView {

    fun loadBannerSuccess(result: BannerBean)

    fun loadHomeListSuccess(result: HomeListBean)

    fun collectSuccess(result: HomeListBean, position: Int)

    fun cancelCollectSuccess(result: HomeListBean, position: Int)
}