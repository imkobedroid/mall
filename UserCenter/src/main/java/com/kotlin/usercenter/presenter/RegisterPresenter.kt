package com.kotlin.usercenter.presenter

import com.kotlin.usercenter.presenter.view.RegisterView
import com.kotlin.usercenter.service.impl.UserServiceImpl
import mall.kotlin.com.baselibrary.common.ext.execute
import mall.kotlin.com.baselibrary.common.presenter.BasePresenter
import mall.kotlin.com.baselibrary.common.rx.BaseSubscribe

/**
 * @author Dsh  on 2018/4/10.
 */
class RegisterPresenter : BasePresenter<RegisterView>() {


    fun register(mobile: String, code: String) {
        val userService = UserServiceImpl()
        userService.register(mobile, code, "").execute(object :BaseSubscribe<Boolean>(){
              override fun onNext(t: Boolean) {
                  mView.registerResult(t)
              }
          })
    }
}