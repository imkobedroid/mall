package com.kotlin.usercenter.data.reposiory

import com.kotlin.usercenter.data.api.UserApi
import com.kotlin.usercenter.data.protocol.*
import io.reactivex.Flowable
import mall.kotlin.com.baselibrary.data.net.RetrofitFactory
import mall.kotlin.com.baselibrary.data.protocol.BaseResp
import javax.inject.Inject

/**
 * @author Dsh  on 2018/4/13.
 */
class UserRepository @Inject constructor() {

    fun register(mobile: String, pwd: String, code: String): Flowable<BaseResp<String>> {
        return RetrofitFactory.instance.createApi(UserApi::class.java).register(RegisterReq(mobile, pwd, code))
    }

    fun login(account:String,pwd: String,pushId:String):Flowable<BaseResp<UserInfo>>{
        return RetrofitFactory.instance.createApi(UserApi::class.java).login(LoginReq(account, pwd, pushId))
    }

    fun forgetPwd(account:String,code: String):Flowable<BaseResp<String>>{
        return RetrofitFactory.instance.createApi(UserApi::class.java).forgetPwd(ForgetPwdReq(account,code))
    }


    fun restPwd(account:String,pwd: String):Flowable<BaseResp<String>>{
        return RetrofitFactory.instance.createApi(UserApi::class.java).restPwd(RestPwdReq(account, pwd))
    }

}