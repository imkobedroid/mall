package com.kotlin.usercenter.presenter

import com.kotlin.usercenter.presenter.view.RegisterView
import mall.kotlin.com.baselibrary.common.presenter.BasePresenter

/**
 * @author Dsh  on 2018/4/10.
 */
class RegisterPresenter : BasePresenter<RegisterView>() {


    fun  register(mobile:String,code:String){
       mView.registerResult(true)
    }
}