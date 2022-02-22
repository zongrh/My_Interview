package cn.zong.wanandroid.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import cn.kotlin.wanandroid.utils.Constant
import cn.kotlin.wanandroid.utils.Utils
import cn.zong.wanandroid.R
import cn.zong.wanandroid.bean.AccountBean
import cn.zong.wanandroid.bean.LoginResponse
import cn.zong.wanandroid.presenter.AccountPresenterImpl
import cn.zong.wanandroid.view.AccountView
import com.blankj.utilcode.util.LogUtils
import kotlinx.android.synthetic.main.activity_account.*

class AccountActivity : AppCompatActivity(), AccountView {

    private val TAG = "AccountActivity"

//    by lazy 只获取不赋值，lazy只用于常量 val
//    lazy 应用于单利模式，(if-null-then-init-else-return)
//    而且当且仅当变量第一次被调用的时候，委托方法才会执行
    private val accountPresenter: AccountPresenterImpl by lazy {
        AccountPresenterImpl(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)

        setSupportActionBar(login_bar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        login_bar.setNavigationOnClickListener {
            finish()
        }

        bt_register.setOnClickListener {
            if (checkInput()) {
                accountPresenter.register(
                    et_username.text.toString(),
                    et_pwd.text.toString(),
                    et_pwd.text.toString()
                )
            }
        }

        bt_login.setOnClickListener {
            if (checkInput()) {
                accountPresenter.login(et_username.text.toString(), et_pwd.text.toString())
            }
        }
    }


    fun checkInput(): Boolean {
        if (TextUtils.isEmpty(et_username.text.toString())) {
            Utils.toast("用户名不能为空")
            return false
        }
        if (TextUtils.isEmpty(et_pwd.text.toString())) {
            Utils.toast("密码不能为空")
            return false
        }
        return true
    }

    /**
     * 登录后的操作
     */
    override fun loginSuccess(result: LoginResponse) {
        if (result.errorCode == 0) {
            LogUtils.e(result)
            Utils.toast("登录成功")
            LogUtils.e(result.toString())
//            保存登录信息
            initAccount(result)
            finish()
        } else {
            Utils.toast(result.errorMsg)
        }
    }

    /**
     * 保存登录后的信息
     */
    private fun initAccount(result: LoginResponse) {
        AccountBean.instance.username = result.data.username
        AccountBean.instance.id = result.data.id
        AccountBean.instance.type = result.data.type
        AccountBean.instance.icon = result.data.icon
        AccountBean.instance.isLogin = true
        AccountBean.instance.collectIds = result.data.collectIds
        Utils.writeToCache(Constant.accountInfo, AccountBean.instance)
    }

    /**
     * 注册后的操作
     */
    override fun registerSuccess(result: LoginResponse) {
        if (result.errorCode == 0) {
            Utils.logE(result.data)
            Utils.toast("注册成功")
            initAccount(result)
            setResult(Constant.AccountCode)
            finish()
        } else {
            Utils.toast(result.errorMsg)
        }
    }

    override fun loading() {

    }

    override fun loadComplete() {
    }

    override fun loadError(msg: String) {
        Utils.toast(msg)
    }
}