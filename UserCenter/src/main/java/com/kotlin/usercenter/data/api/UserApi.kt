package com.kotlin.usercenter.data.api

import com.kotlin.usercenter.data.protocol.RegisterReq
import io.reactivex.Flowable
import mall.kotlin.com.baselibrary.data.protocol.BaseResp
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * @author Dsh  on 2018/4/13.
 */
interface UserApi {
    @POST("userCenter/register")
    fun register(@Body rep: RegisterReq):Flowable<BaseResp<String>>
}