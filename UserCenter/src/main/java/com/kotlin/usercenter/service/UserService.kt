package com.kotlin.usercenter.service

import com.kotlin.usercenter.data.protocol.UserInfo
import io.reactivex.Flowable

/**
 * @author Dsh  on 2018/4/12.
 */
interface UserService {
    fun register(mobile: String, code: String, pwd: String): Flowable<Boolean>
    fun login(mobile: String, pwd: String, pushId: String): Flowable<UserInfo>
    fun forgetPwd(mobile: String, code: String): Flowable<Boolean>
    fun restPwd(mobile: String, pwd: String): Flowable<Boolean>
}