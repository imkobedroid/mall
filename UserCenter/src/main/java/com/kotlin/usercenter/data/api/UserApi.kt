package com.kotlin.usercenter.data.api

import com.kotlin.usercenter.data.protocol.LoginInfo
import io.reactivex.Flowable
import mall.kotlin.com.baselibrary.data.protocol.BaseResp
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author Dsh  on 2018/4/13.
 */
interface UserApi {

    @GET("/players/branchs/branch-regions")
    fun login(
            @Query("code") code: String
    ): Flowable<BaseResp<List<LoginInfo>>>
}