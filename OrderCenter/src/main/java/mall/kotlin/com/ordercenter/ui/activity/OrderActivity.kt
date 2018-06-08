package com.kotlin.order.ui.activity

import android.os.Bundle
import android.support.design.widget.TabLayout
import kotlinx.android.synthetic.main.activity_order.*
import mall.kotlin.com.baselibrary.ui.activity.BaseActivity
import mall.kotlin.com.ordercenter.R
import mall.kotlin.com.ordercenter.common.OrderConstant
import mall.kotlin.com.ordercenter.common.OrderStatus
import mall.kotlin.com.ordercenter.ui.adapter.OrderVpAdapter

/*
    订单Activity
    主要包括不同订单状态的Fragment
 */
class OrderActivity: BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        initView()
    }

    /*
        初始化视图
     */
    private fun initView() {
        mOrderTab.tabMode = TabLayout.MODE_FIXED
        mOrderVp.adapter = OrderVpAdapter(supportFragmentManager,this)
        mOrderTab.setupWithViewPager(mOrderVp)

        //根据订单状态设置当前页面
        mOrderVp.currentItem = intent.getIntExtra(OrderConstant.KEY_ORDER_STATUS, OrderStatus.ORDER_ALL)
    }
}
