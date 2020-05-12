package com.kotlin.usercenter.presenter

import com.kotlin.usercenter.data.protocol.LoginInfo
import com.kotlin.usercenter.presenter.view.LoginView
import com.kotlin.usercenter.service.UserService
import mall.kotlin.com.baselibrary.ext.execute
import mall.kotlin.com.baselibrary.presenter.BasePresenter
import mall.kotlin.com.baselibrary.rx.BaseSubscribe
import javax.inject.Inject
import javax.inject.Named

/**
 * @author Dsh  imkobedroid@gmail.com
 * @date 2020/5/12
 */
open class LoginPresenter @Inject constructor() : BasePresenter<LoginView>() {

    @Inject
    @field:[Named("service")]
    lateinit var userService: UserService

    fun login(code: String) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        userService.login(code).execute(object : BaseSubscribe<List<LoginInfo>>(mView) {
            override fun onNext(t: List<LoginInfo>) {
                mView.loginResult(t)
            }
        }, lifecycleProvider)
    }
}