package cn.zong.wanandroid.bean

/**
 *
 * FileName: LoginResponse
 * Author: nanzong
 * Date: 2022/2/22 2:57 下午
 * Description:
 * History:
 *
 */
data class LoginResponse(
    val `data`: Data,
    val errorCode: Int,
    val errorMsg: String
) {
    data class Data(
        val admin: Boolean,
        val chapterTops: List<Any>,
        val coinCount: Int,
        val collectIds: List<Int>,
        val email: String,
        val icon: String,
        val id: Int,
        val nickname: String,
        val password: String,
        val publicName: String,
        val token: String,
        val type: Int,
        val username: String

    ) {
        override fun toString(): String {
            return "Data(admin=$admin, chapterTops=$chapterTops, coinCount=$coinCount, collectIds=$collectIds, email='$email', icon='$icon', id=$id, nickname='$nickname', password='$password', publicName='$publicName', token='$token', type=$type, username='$username')"
        }
    }

    override fun toString(): String {
        return "LoginResponse(`data`=$`data`, errorCode=$errorCode, errorMsg='$errorMsg')"
    }
}

