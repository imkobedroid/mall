package com.kotlin.usercenter.injection.component

import com.kotlin.usercenter.injection.module.UserModule
import com.kotlin.usercenter.ui.LoginActivity
import dagger.Component
import mall.kotlin.com.baselibrary.injection.PerComponentScope
import mall.kotlin.com.baselibrary.injection.component.ActivityComponent

/**
 * @author Dsh  imkobedroid@gmail.com
 * @date 2020/5/12
 */
@PerComponentScope
@Component(modules = [(UserModule::class)], dependencies = [(ActivityComponent::class)])
interface UserComponent {
   fun inject(activity: LoginActivity)
}