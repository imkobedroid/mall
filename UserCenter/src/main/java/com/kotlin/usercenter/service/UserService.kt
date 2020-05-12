package com.kotlin.usercenter.service

import com.kotlin.usercenter.data.protocol.LoginInfo
import io.reactivex.Flowable

/**
 * @author Dsh  imkobedroid@gmail.com
 * @date 2020/5/12
 */
interface UserService {
    fun login(code: String): Flowable<List<LoginInfo>>
}