package com.kotlin.usercenter.service.impl

import com.kotlin.usercenter.data.protocol.LoginInfo
import com.kotlin.usercenter.data.reposiory.UserRepository
import com.kotlin.usercenter.service.UserService
import io.reactivex.Flowable
import mall.kotlin.com.baselibrary.ext.convert
import javax.inject.Inject

/**
 * @author Dsh  imkobedroid@gmail.com
 * @date 2020/5/12
 */
class UserServiceImpl @Inject constructor() : UserService {
    @Inject
    lateinit var repository: UserRepository


    override fun login(code: String): Flowable<List<LoginInfo>> {
        return repository.login(code).convert()
    }

}


