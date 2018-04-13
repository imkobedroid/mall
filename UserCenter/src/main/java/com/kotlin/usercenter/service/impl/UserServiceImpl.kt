package com.kotlin.usercenter.service.impl

import com.kotlin.usercenter.data.reposiory.UserRepository
import com.kotlin.usercenter.service.UserService
import io.reactivex.Flowable
import mall.kotlin.com.baselibrary.rx.BaseException
import javax.inject.Inject

/**
 * @author Dsh  on 2018/4/12.
 */
class UserServiceImpl  @Inject constructor(): UserService {
    override fun register(mobile: String, code: String, pwd: String): Flowable<Boolean> {
        return UserRepository().register(mobile, pwd, code).flatMap {
            if (it.status != 1) {
                Flowable.error(BaseException(it.status, it.message))
            } else {
                Flowable.just(true)
            }
        }
    }
}