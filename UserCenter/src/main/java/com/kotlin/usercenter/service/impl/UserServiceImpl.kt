package com.kotlin.usercenter.service.impl

import com.kotlin.usercenter.data.protocol.UserInfo
import com.kotlin.usercenter.data.reposiory.UserRepository
import com.kotlin.usercenter.service.UserService
import io.reactivex.Flowable
import javax.inject.Inject
import mall.kotlin.com.baselibrary.ext.convert
import mall.kotlin.com.baselibrary.ext.convertBoolean

/**
 * @author Dsh  on 2018/4/12.
 */
class UserServiceImpl @Inject constructor() : UserService {
    @Inject
    lateinit var repository: UserRepository

    override fun login(mobile: String, pwd: String, pushId: String): Flowable<UserInfo> {
        return repository.login(mobile,pwd,pushId).convert()
    }

    override fun register(mobile: String, code: String, pwd: String): Flowable<Boolean> {
        return repository.register(mobile, pwd, code).convertBoolean()
    }
}


