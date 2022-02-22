package cn.zong.wanandroid.presenter

/**
 *
 * FileName: AccountPresenter
 * Author: nanzong
 * Date: 2022/2/22 4:42 下午
 * Description:
 * History:
 *
 */
interface AccountPresenter {

    fun login(username: String, password: String)

    fun register(username: String, password: String, repassword: String)

}