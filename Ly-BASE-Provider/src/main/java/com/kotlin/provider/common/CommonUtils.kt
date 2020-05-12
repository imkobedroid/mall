package com.kotlin.provider.common

import com.alibaba.android.arouter.launcher.ARouter


/**
 * @author Dsh  imkobedroid@gmail.com
 * @date 2020/5/12
 */


fun start() {
    ARouter.getInstance().build(ProviderConstant.PATH).navigation()
}