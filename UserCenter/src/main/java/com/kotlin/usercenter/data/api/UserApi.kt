package com.kotlin.usercenter.data.api

import com.kotlin.usercenter.data.protocol.RegisterReq
import com.kotlin.usercenter.ui.ServiceBean
import io.reactivex.Flowable
import mall.kotlin.com.baselibrary.data.protocol.BaseResp
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * @author Dsh  on 2018/4/13.
 */
interface UserApi {
    @POST("userCenter/register")
    fun register(@Body rep: RegisterReq):Flowable<BaseResp<String>>


    /**
     * 获取服务器列表
     * @param phone 参数
     * @param nonce 参数
     * @param sign 参数
     * @param method 参数
     * @param uid 参数
     * @return 服务器列表
     */
    @GET("/api.php")
    fun questServiceData(@Query("app_id") phone: String,
                         @Query("nonce") nonce: String,
                         @Query("sign") sign: String,
                         @Query("method") method: String,
                         @Query("uid") uid: String): Flowable<ServiceBean>
}