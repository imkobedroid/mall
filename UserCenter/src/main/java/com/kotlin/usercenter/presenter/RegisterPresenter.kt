package com.kotlin.usercenter.presenter

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
        userService.register(mobile, pwd, code).execute(object : BaseSubscribe<Boolean>() {
            override fun onNext(t: Boolean) {
                mView.registerResult(t)
            }
        }, lifecycleProvider)
    }


    fun getService(app_id: String, nonce: String, sign: String, method: String, uid: String) {
        userService.questService(app_id, nonce, sign, method, uid).execute(object : BaseSubscribe<ServiceBean>() {
            override fun onNext(t: ServiceBean) {
                super.onNext(t)
                mView.getService(t)
            }
        }, lifecycleProvider)
    }


}