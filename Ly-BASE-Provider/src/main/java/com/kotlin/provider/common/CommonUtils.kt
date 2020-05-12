package com.kotlin.provider.common

import com.alibaba.android.arouter.launcher.ARouter
import com.kotlin.provider.common.ProviderConstant.Companion.PATH


/**
 * @author Dsh  imkobedroid@gmail.com
 * @date 2020/5/12
 */


fun start() {
    // 1. 应用内简单的跳转(通过URL跳转在'进阶用法'中)
    ARouter.getInstance().build(PATH).navigation()

//    // 2. 跳转并携带参数
//    ARouter.getInstance().build("/test/1")
//            .withLong("key1", 666L)
//            .withString("key3", "888")
//            .withObject("key4", Test("Jack", "Rose"))
//            .navigation()
}