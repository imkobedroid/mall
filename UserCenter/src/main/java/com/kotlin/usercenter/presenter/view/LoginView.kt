package com.kotlin.usercenter.presenter.view

import com.kotlin.usercenter.data.protocol.UserInfo
import mall.kotlin.com.baselibrary.presenter.view.BaseView

/**
 * @author Dsh  on 2018/4/10.
 */

interface LoginView : BaseView {

     fun loginResult(b: UserInfo)

}