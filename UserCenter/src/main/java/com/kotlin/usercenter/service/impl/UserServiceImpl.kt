package com.kotlin.usercenter.service.impl

import com.kotlin.usercenter.service.UserService
import io.reactivex.Flowable

/**
 * @author Dsh  on 2018/4/12.
 */
class UserServiceImpl :UserService {
    override fun register(mobile: String, code: String, pwd: String): Flowable<Boolean> {
          return Flowable.just(false)
    }
}