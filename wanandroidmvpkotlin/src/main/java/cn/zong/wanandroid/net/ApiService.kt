package cn.zong.wanandroid.net

import cn.zong.wanandroid.bean.BannerBean
import cn.zong.wanandroid.bean.HomeListBean
import cn.zong.wanandroid.bean.LoginResponse
import io.reactivex.Observable
import retrofit2.http.*

/**
 *
 * FileName: ApiService
 * Author: nanzong
 * Date: 2022/2/22 1:28 下午
 * Description:
 * History:
 *
 */
interface ApiService {

    /**
     * 首页Banner
     */
    @GET("/banner/json")
    fun getBanner(): Observable<BannerBean>

    /**
     * 首页数据
     * http://www.wanandroid.com/article/list/0/json
     * @param page page
     */
    @GET("/article/list/{page}/json")
    fun getHomeList(@Path("page") page: Int): Observable<HomeListBean>
    /**
     * 收藏文章
     * @param id id
     * @return Deferred<HomeListResponse>
     */
    @POST("/lg/collect/{id}/json")
    fun addCollectArticle(@Path("id") id: Int): Observable<HomeListBean>

    /**
     * 删除收藏文章
     * @param id id
     * @return Deferred<HomeListResponse>
     */
    @POST("/lg/uncollect_originId/{id}/json")
    fun removeCollectArticle(@Path("id") id: Int): Observable<HomeListBean>

    /**
     * 注册
     */
    @POST("/user/register")
    @FormUrlEncoded
    fun registerWanAndroid(
        @Field("username") username: String,
        @Field("password") password: String,
        @Field("repassword") repassowrd: String
    ): Observable<LoginResponse>


    /**
     * 登录
     * @param  username
     * @param password
     */
    @POST("/user/login")
    fun loginWanAndroid(
        @Query("username") username: String,
        @Query("password") password: String
    ): Observable<LoginResponse>


}