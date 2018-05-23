package com.kotlin.usercenter.injection.component

import com.kotlin.usercenter.injection.module.UserModule
import com.kotlin.usercenter.ui.ForgetPwdActivity
import com.kotlin.usercenter.ui.LoginActivity
import com.kotlin.usercenter.ui.RegisterActivity
import com.kotlin.usercenter.ui.ResetPwdActivity
import dagger.Component
import mall.kotlin.com.baselibrary.injection.PerComponentScope
import mall.kotlin.com.baselibrary.injection.component.ActivityComponent

/**
 * @author Dsh  on 2018/4/16.
 */

@PerComponentScope
@Component (modules = [(UserModule::class)],dependencies = [(ActivityComponent::class)])
interface UserComponent {
   fun inject(activity: LoginActivity)
   fun inject(activity: RegisterActivity)
   fun inject(activity: ForgetPwdActivity)
   fun inject(activity: ResetPwdActivity)
}