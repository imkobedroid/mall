package com.kotlin.usercenter.presenter

import com.kotlin.usercenter.presenter.view.RegisterView
import com.kotlin.usercenter.service.UserService
import mall.kotlin.com.baselibrary.ext.execute
import mall.kotlin.com.baselibrary.presenter.BasePresenter
import mall.kotlin.com.baselibrary.rx.BaseSubscribe
import javax.inject.Inject

/**
 * @author Dsh  on 2018/4/10.
 */
open class RegisterPresenter @Inject constructor() : BasePresenter<RegisterView>() {

     @Inject lateinit var userService: UserService
    fun register(mobile: String, code: String, pwd: String) {
        userService.register(mobile, pwd, code).execute(object : BaseSubscribe<Boolean>() {
            override fun onNext(t: Boolean) {
                mView.registerResult(t)
            }
        })
    }
}