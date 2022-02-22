package cn.zong.wanandroid.bean

import java.io.Serializable

/**
 *
 * FileName: HomeListBean
 * Author: nanzong
 * Date: 2022/2/22 8:30 下午
 * Description:
 * History:
 *
 */
class HomeListBean(
    var data: Data,
    var errorCode: Int,
    var errorMsg: String
) {


    data class Data(
        var curPage: Int,
        var datas: List<Datas>,
        var offset: Int,
        var over: Boolean,
        var pageCount: Int,
        var size: Int,
        var total: Int
    ) {
        override fun toString(): String {
            return "Data(curPage=$curPage, datas=$datas, offset=$offset, over=$over, pageCount=$pageCount, size=$size, total=$total)"
        }
    }

    data class Datas(
        var apkLink: String,
        var audit: Int,
        var author: String,
        var canEdit: Boolean,
        var chapterId: Int,
        var chapterName: String,
        var collect: Boolean,
        var courseId: Int,
        var desc: String,
        var descMd: String,
        var envelopePic: String,
        var fresh: Boolean,
        var host: String,
        var id: Int,
        var link: String,
        var niceDate: String,
        var niceShareDate: String,
        var origin: String,
        var prefix: String,
        var projectLink: String,
        var publishTime: Long,
        var realSuperChapterId: Int,
        var selfVisible: Int,
        var shareDate: Long,
        var shareUser: String,
        var superChapterId: Int,
        var superChapterName: String,
        var tags: Any,
        var title: String,
        var type: Int,
        var userId: Int,
        var visible: Int,
        var zan: Int
    ) : Serializable


}
