package com.kotlin.usercenter.presenter

import android.util.Log
import com.kotlin.usercenter.presenter.view.RegisterView
import com.kotlin.usercenter.service.UserService
import com.kotlin.usercenter.ui.ServiceBean
import mall.kotlin.com.baselibrary.ext.execute
import mall.kotlin.com.baselibrary.presenter.BasePresenter
import mall.kotlin.com.baselibrary.rx.BaseSubscribe
import java.util.*
import javax.inject.Inject
import javax.inject.Named

/**
 * @author Dsh  on 2018/4/10.
 */
open class RegisterPresenter @Inject constructor() : BasePresenter<RegisterView>() {

    @Inject
    @field:[Named("service")]
    lateinit var userService: UserService


    fun register(mobile: String, code: String, pwd: String) {

        if (!checkNetWork()) {
            Log.v("网络", "不可用")
            return
        }
        mView.showLoading()
        userService.register(mobile, pwd, code).execute(object : BaseSubscribe<Boolean>(mView) {
            override fun onNext(t: Boolean) {
                mView.registerResult(t)
            }
        }, lifecycleProvider)
    }
}