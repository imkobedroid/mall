package com.kotlin.usercenter.data.api

import com.kotlin.usercenter.data.protocol.*
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

    @POST("userCenter/login")
    fun login(@Body rep: LoginReq):Flowable<BaseResp<UserInfo>>

    @POST("userCenter/forgetPwd")
    fun forgetPwd(@Body rep: ForgetPwdReq):Flowable<BaseResp<String>>

    @POST("userCenter/restPwd")
    fun restPwd(@Body rep: RestPwdReq):Flowable<BaseResp<String>>

}