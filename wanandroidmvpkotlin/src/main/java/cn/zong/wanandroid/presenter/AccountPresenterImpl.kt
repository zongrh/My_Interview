package cn.zong.wanandroid.presenter

import cn.zong.wanandroid.bean.LoginResponse
import cn.zong.wanandroid.net.ApiService
import cn.zong.wanandroid.net.RetrofitHelper
import cn.zong.wanandroid.view.AccountView
import com.blankj.utilcode.util.LogUtils
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 *
 * FileName: AccountPresenterImpl
 * Author: nanzong
 * Date: 2022/2/22 4:44 下午
 * Description:
 * History:
 *
 */
class AccountPresenterImpl(view: AccountView) : AccountPresenter {
    private var mView: AccountView = view

    override fun login(username: String, password: String) {

        RetrofitHelper.instance.create(ApiService::class.java)
            .loginWanAndroid(username, password)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<LoginResponse> {
                override fun onSubscribe(d: Disposable?) {

                }

                override fun onNext(value: LoginResponse) {
                    mView.loginSuccess(value)
                }

                override fun onError(e: Throwable) {
                    mView.loadError(e.toString())
                }

                override fun onComplete() {
                    mView.loadComplete()
                }
            })
    }

    override fun register(username: String, password: String, repassword: String) {
        RetrofitHelper.instance.create(ApiService::class.java)
            .registerWanAndroid(username, password, repassword)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<LoginResponse> {
                override fun onSubscribe(d: Disposable?) {

                }

                override fun onNext(value: LoginResponse) {
                    LogUtils.e(value.toString())
                    mView.registerSuccess(value)
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