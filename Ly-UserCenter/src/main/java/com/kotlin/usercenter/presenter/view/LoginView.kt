package com.kotlin.usercenter.presenter.view

import com.kotlin.usercenter.data.protocol.LoginInfo
import mall.kotlin.com.baselibrary.presenter.view.BaseView

/**
 * @author Dsh  imkobedroid@gmail.com
 * @date 2020/5/12
 */

interface LoginView : BaseView {
     fun loginResult(b: List<LoginInfo>)
}