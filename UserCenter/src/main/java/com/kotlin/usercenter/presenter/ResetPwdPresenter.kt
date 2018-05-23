package com.kotlin.usercenter.presenter

import com.kotlin.usercenter.presenter.view.ResetPwdView
import com.kotlin.usercenter.service.UserService
import mall.kotlin.com.baselibrary.ext.execute
import mall.kotlin.com.baselibrary.presenter.BasePresenter
import mall.kotlin.com.baselibrary.rx.BaseSubscribe
import javax.inject.Inject
import javax.inject.Named

/**
 * @author Dsh  on 2018/4/10.
 */
open class ResetPwdPresenter @Inject constructor() : BasePresenter<ResetPwdView>() {

    @Inject
    @field:[Named("service")]
    lateinit var userService: UserService

    fun resetPwd(mobile: String, code: String) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        userService.restPwd(mobile, code).execute(object : BaseSubscribe<Boolean>(mView) {
            override fun onNext(t: Boolean) {
                mView.resetPwdResult(t)
            }
        }, lifecycleProvider)
    }
}