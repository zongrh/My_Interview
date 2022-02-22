package cn.zong.wanandroid.bean

/**
 *
 * FileName: BannerBean
 * Author: nanzong
 * Date: 2022/2/22 1:25 下午
 * Description:
 * History:
 *
 */
data class BannerBean(
    val `data`: List<Data>,
    val errorCode: Int,
    val errorMsg: String
) {

    data class Data(
        val desc: String,
        val id: Int,
        val imagePath: String,
        val isVisible: Int,
        val order: Int,
        val title: String,
        val type: Int,
        val url: String
    ){
        override fun toString(): String {
            return "Data(desc='$desc', id=$id, imagePath='$imagePath', isVisible=$isVisible, order=$order, title='$title', type=$type, url='$url')"
        }
    }

    override fun toString(): String {
        return "BannerBean(`data`=$`data`, errorCode=$errorCode, errorMsg='$errorMsg')"
    }

}
