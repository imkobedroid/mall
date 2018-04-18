package com.kotlin.usercenter.service.impl

import com.kotlin.usercenter.data.reposiory.UserRepository
import com.kotlin.usercenter.service.UserService
import com.kotlin.usercenter.ui.ServiceBean
import io.reactivex.Flowable
import mall.kotlin.com.baselibrary.rx.BaseFunc
import mall.kotlin.com.baselibrary.rx.BaseFuncBoolean
import javax.inject.Inject

/**
 * @author Dsh  on 2018/4/12.
 */
class UserServiceImpl @Inject constructor() : UserService {

    @Inject
    lateinit var repository: UserRepository

    override fun questService(app_id: String, nonce: String, sign: String, method: String, uid: String): Flowable<ServiceBean> {
        return repository.getService(app_id,nonce,sign,method,uid)
    }

    override fun register(mobile: String, code: String, pwd: String): Flowable<Boolean> {
        return repository.register(mobile, pwd, code).flatMap(BaseFuncBoolean())
    }
}