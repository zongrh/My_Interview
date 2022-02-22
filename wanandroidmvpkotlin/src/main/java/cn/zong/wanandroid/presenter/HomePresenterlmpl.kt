package cn.zong.wanandroid.presenter

import cn.zong.wanandroid.bean.BannerBean
import cn.zong.wanandroid.bean.HomeListBean
import cn.zong.wanandroid.net.ApiService
import cn.zong.wanandroid.net.RetrofitHelper
import cn.zong.wanandroid.view.HomeView
import cn.zong.wanandroid.view.iBaseView
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 *
 * FileName: HomePresenterlmpl
 * Author: nanzong
 * Date: 2022/2/22 8:35 下午
 * Description:
 * History:
 *
 */
class HomePresenterlmpl(view: iBaseView) : HomePresenter {
    var mView: HomeView = view as HomeView

    //获取banner
    override fun getBanner() {
        mView.loading()
        RetrofitHelper.instance.create(ApiService::class.java)
            .getBanner()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<BannerBean> {
                override fun onComplete() {
                    mView.loadComplete()
                }

                override fun onSubscribe(d: Disposable?) {
                }

                override fun onNext(value: BannerBean?) {
                    mView.loadBannerSuccess(value!!)
                }

                override fun onError(e: Throwable?) {
                    mView.loadError(e.toString())
                }

            })
    }


    override fun getHomeList(curPage: Int) {

        mView.loading()
        RetrofitHelper.instance.create(ApiService::class.java)
            .getHomeList(curPage)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<HomeListBean> {
                override fun onComplete() {
                    mView.loadComplete()
                }

                override fun onSubscribe(d: Disposable?) {
                }

                override fun onNext(value: HomeListBean?) {
                    mView.loadHomeListSuccess(value!!)
                }

                override fun onError(e: Throwable?) {
                    mView.loadError(e.toString())
                }

            })
    }
    //收藏
    override fun collect(id: Int, position: Int) {
        mView.loading()
        RetrofitHelper.instance.create(ApiService::class.java)
            .addCollectArticle(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<HomeListBean> {
                override fun onSubscribe(d: Disposable?) {}

                override fun onNext(value: HomeListBean?) {
                    mView.collectSuccess(value!!, position)
                }

                override fun onError(e: Throwable?) {
                    mView.loadError(e.toString())
                }

                override fun onComplete() {
                    mView.loadComplete()
                }
            })
    }

    //取消收藏
    override fun cancelCollect(id: Int, position: Int) {
        mView.loading()
        RetrofitHelper.instance.create(ApiService::class.java)
            .removeCollectArticle(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<HomeListBean> {
                override fun onSubscribe(d: Disposable?) {}

                override fun onNext(value: HomeListBean?) {
                    mView.cancelCollectSuccess(value!!, position)
                }

                override fun onError(e: Throwable?) {
                    mView.loadError(e.toString())
                }

                override fun onComplete() {
                    mView.loadComplete()
                }
            })
    }

}