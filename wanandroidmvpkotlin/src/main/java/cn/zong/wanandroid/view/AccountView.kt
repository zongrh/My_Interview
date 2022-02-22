package cn.zong.wanandroid.view

import cn.zong.wanandroid.bean.LoginResponse

/**
 *
 * FileName: AccountView
 * Author: nanzong
 * Date: 2022/2/22 4:39 下午
 * Description:
 * History:
 */

interface AccountView : iBaseView {

    fun loginSuccess(result: LoginResponse)

    fun registerSuccess(result: LoginResponse)

}