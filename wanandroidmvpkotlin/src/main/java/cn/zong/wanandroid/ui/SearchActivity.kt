package cn.zong.wanandroid.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import cn.zong.wanandroid.R
import cn.zong.wanandroid.bean.BannerBean
import cn.zong.wanandroid.net.ApiService
import cn.zong.wanandroid.net.RetrofitHelper
import com.blankj.utilcode.util.LogUtils
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : AppCompatActivity() {
    private val TAG = "SearchActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        setSupportActionBar(stoolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        stoolbar.setNavigationOnClickListener {
            finish()
        }
        search_rv.layoutManager = LinearLayoutManager(this)
//        search_rv.adapter=
        getData()
    }

    private fun getData() {
        RetrofitHelper.instance.create(ApiService::class.java)
            .getBanner()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<BannerBean> {
                override fun onSubscribe(d: Disposable?) {
                }

                override fun onNext(value: BannerBean?) {
                    LogUtils.i(TAG,value.toString())
                    LogUtils.i(TAG,value.toString())

                }

                override fun onError(e: Throwable?) {
                }

                override fun onComplete() {

                }

            })
    }
}