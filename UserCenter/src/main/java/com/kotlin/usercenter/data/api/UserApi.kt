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

}