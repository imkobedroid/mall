package com.kotlin.provider.common

import mall.kotlin.com.baselibrary.common.BaseConstance
import mall.kotlin.com.baselibrary.utils.AppPrefsUtils

/**
 * @author Dsh  on 2018/5/25.
 */


fun isLogin():Boolean{
    return AppPrefsUtils.getString(BaseConstance.KEY_SP_TOKEN).isNotEmpty()
}