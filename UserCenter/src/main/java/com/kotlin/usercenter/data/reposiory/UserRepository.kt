package com.kotlin.usercenter.data.reposiory

import com.kotlin.usercenter.data.api.UserApi
import com.kotlin.usercenter.data.protocol.RegisterReq
import com.kotlin.usercenter.ui.ServiceBean
import io.reactivex.Flowable
import mall.kotlin.com.baselibrary.data.net.RetrofitFactory
import mall.kotlin.com.baselibrary.data.protocol.BaseResp
import retrofit2.http.Query
import javax.inject.Inject

/**
 * @author Dsh  on 2018/4/13.
 */
class UserRepository @Inject constructor() {

    fun register(mobile: String, pwd: String, code: String): Flowable<BaseResp<String>> {
        return RetrofitFactory.instance.createApi(UserApi::class.java).register(RegisterReq(mobile, pwd, code))
    }


    fun getService(app_id: String,
                   nonce: String,
                   sign: String,
                   method: String,
                   uid: String): Flowable<ServiceBean> {
        return RetrofitFactory.instance.createApi(UserApi::class.java).questServiceData(app_id,nonce,sign,method,uid)

    }
}