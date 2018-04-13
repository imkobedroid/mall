package com.kotlin.usercenter.presenter

import com.kotlin.usercenter.presenter.view.RegisterView
import com.kotlin.usercenter.service.impl.UserServiceImpl
import mall.kotlin.com.baselibrary.ext.execute
import mall.kotlin.com.baselibrary.presenter.BasePresenter
import mall.kotlin.com.baselibrary.rx.BaseSubscribe

/**
 * @author Dsh  on 2018/4/10.
 */
class RegisterPresenter : BasePresenter<RegisterView>() {


    fun register(mobile: String, code: String, pwd: String) {
        val userService = UserServiceImpl()

        userService.register(mobile, pwd, code).execute(object : BaseSubscribe<Boolean>() {
            override fun onNext(t: Boolean) {
                mView.registerResult(t)
            }
        })
    }
}