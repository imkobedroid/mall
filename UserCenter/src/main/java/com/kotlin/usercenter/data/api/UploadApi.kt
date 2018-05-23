package com.kotlin.usercenter.data.api

import io.reactivex.Flowable
import mall.kotlin.com.baselibrary.data.protocol.BaseResp
import retrofit2.http.POST

/**
 * @author Dsh  on 2018/4/13.
 */
interface UploadApi {
    @POST("common/getUploadToken")
    fun getUploadToken(): Flowable<BaseResp<String>>

}