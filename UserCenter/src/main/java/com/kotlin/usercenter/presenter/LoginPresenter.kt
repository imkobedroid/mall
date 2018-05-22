package com.kotlin.usercenter.presenter

import com.kotlin.usercenter.data.protocol.UserInfo
import com.kotlin.usercenter.presenter.view.LoginView
import com.kotlin.usercenter.service.UserService
import mall.kotlin.com.baselibrary.ext.execute
import mall.kotlin.com.baselibrary.presenter.BasePresenter
import mall.kotlin.com.baselibrary.rx.BaseSubscribe
import javax.inject.Inject
import javax.inject.Named

/**
 * @author Dsh  on 2018/4/10.
 */
open class  LoginPresenter @Inject constructor() : BasePresenter<LoginView>() {

    @Inject
    @field:[Named("service")]
    lateinit var userService: UserService

    fun login(mobile: String, pwd: String, pushId: String) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        userService.login(mobile, pwd, pushId).execute(object : BaseSubscribe<UserInfo>(mView) {
            override fun onNext(t: UserInfo) {
                mView.loginResult(t)
            }
        }, lifecycleProvider)
    }
}