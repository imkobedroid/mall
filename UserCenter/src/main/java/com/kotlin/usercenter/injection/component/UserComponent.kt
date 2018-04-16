package com.kotlin.usercenter.injection.component

import com.kotlin.usercenter.injection.module.UserModule
import com.kotlin.usercenter.ui.MainActivity
import dagger.Component

/**
 * @author Dsh  on 2018/4/16.
 */


@Component (modules = [(UserModule::class)])
interface UserComponent {
   fun inject(activity: MainActivity)
}