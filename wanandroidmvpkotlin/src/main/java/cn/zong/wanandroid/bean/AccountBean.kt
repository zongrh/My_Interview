package cn.zong.wanandroid.bean

import cn.kotlin.wanandroid.utils.Constant
import cn.kotlin.wanandroid.utils.Preference
import cn.kotlin.wanandroid.utils.Utils
import java.io.Serializable

/**
 *
 * FileName: AccountBean
 * Author: nanzong
 * Date: 2022/2/22 5:08 下午
 * Description:  记得当前账号
 * History:
 *
 */
//记录当前账号
class AccountBean constructor(
    var id: Int, var username: String, var icon: String,
    var type: Int, var collectIds: List<Int>?,
    var isLogin: Boolean
) : Serializable {
    companion object {
        val instance: AccountBean by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            if (Utils.restoreObject(Constant.accountInfo) != null) {
                var acconut: AccountBean = Utils.restoreObject(Constant.accountInfo) as AccountBean
                AccountBean(
                    acconut.id, acconut.username, acconut.icon, acconut.type,
                    acconut.collectIds, acconut.isLogin
                )
            } else {
                AccountBean(0, "", "", 0, null, false)
            }
            AccountBean(0, "", "", 0, null, false)
        }
    }
    fun clear(){
        Preference.clear()
        id = 0
        username = ""
        icon = ""
        type = 0
        collectIds = null
        isLogin = false
        Utils.writeToCache(Constant.accountInfo, AccountBean.instance)
    }

    override fun toString(): String {
        return "AccountBean(id=$id, username='$username', icon='$icon', type=$type, collectIds=$collectIds, isLogin=$isLogin)"
    }

}

