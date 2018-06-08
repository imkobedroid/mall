package com.kotlin.order.injection.component

import mall.kotlin.com.ordercenter.injection.module.OrderModule
import mall.kotlin.com.ordercenter.ui.activity.OrderConfirmActivity
import mall.kotlin.com.ordercenter.ui.activity.OrderDetailActivity
import mall.kotlin.com.ordercenter.ui.fragment.OrderFragment
import dagger.Component
import mall.kotlin.com.baselibrary.injection.PerComponentScope
import mall.kotlin.com.baselibrary.injection.component.ActivityComponent

/*
    订单Component
 */
@PerComponentScope
@Component(dependencies = [(ActivityComponent::class)],modules = [(OrderModule::class)])
interface OrderComponent {
    fun inject(activity: OrderConfirmActivity)
    fun inject(fragment: OrderFragment)

    fun inject(activity: OrderDetailActivity)
}
