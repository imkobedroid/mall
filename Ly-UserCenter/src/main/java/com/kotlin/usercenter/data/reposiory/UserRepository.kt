package com.kotlin.usercenter.data.reposiory

import com.kotlin.usercenter.data.api.UserApi
import com.kotlin.usercenter.data.protocol.LoginInfo
import io.reactivex.Flowable
import mall.kotlin.com.baselibrary.data.net.RetrofitFactory
import mall.kotlin.com.baselibrary.data.protocol.BaseResp
import javax.inject.Inject

/**
 * @author Dsh  imkobedroid@gmail.com
 * @date 2020/5/12
 */
class UserRepository @Inject constructor() {


    fun login(code: String): Flowable<BaseResp<List<LoginInfo>>> {
        return RetrofitFactory.instance.createApi(UserApi::class.java).login(code)
    }


}