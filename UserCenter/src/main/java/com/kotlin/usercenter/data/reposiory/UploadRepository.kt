package com.kotlin.usercenter.data.reposiory

import com.kotlin.usercenter.data.api.UploadApi
import io.reactivex.Flowable
import mall.kotlin.com.baselibrary.data.net.RetrofitFactory
import mall.kotlin.com.baselibrary.data.protocol.BaseResp
import javax.inject.Inject

/**
 * @author Dsh  on 2018/4/13.
 */
class UploadRepository @Inject constructor() {


    fun getUploadToken(): Flowable<BaseResp<String>> {
        return RetrofitFactory.instance.createApi(UploadApi::class.java).getUploadToken()
    }
}