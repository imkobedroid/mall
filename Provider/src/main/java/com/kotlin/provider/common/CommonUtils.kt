package com.kotlin.provider.common

import com.alibaba.android.arouter.launcher.ARouter
import com.kotlin.provider.router.RouterPath
import mall.kotlin.com.baselibrary.common.BaseConstance
import mall.kotlin.com.baselibrary.utils.AppPrefsUtils

/**
 * @author Dsh  on 2018/5/25.
 */


fun isLogin():Boolean{
    return AppPrefsUtils.getString(BaseConstance.KEY_SP_TOKEN).isNotEmpty()
}


fun afterLogin(method:() ->Unit){
    if (isLogin()) method else ARouter.getInstance().build(RouterPath.UserCenter.PATH_LOGIN).navigation()
}