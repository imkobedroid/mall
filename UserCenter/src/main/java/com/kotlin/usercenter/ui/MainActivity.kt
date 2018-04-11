package com.kotlin.usercenter.ui

import android.os.Bundle
import com.kotlin.usercenter.R
import com.kotlin.usercenter.presenter.RegisterPresenter
import com.kotlin.usercenter.presenter.view.RegisterView
import kotlinx.android.synthetic.main.login.*
import mall.kotlin.com.baselibrary.common.ui.activity.BaseMvpActivity
import org.jetbrains.anko.toast

class MainActivity : BaseMvpActivity<RegisterPresenter>(), RegisterView{
    override fun registerResult(b: Boolean) {
        toast("注册成功")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
        toast("dfsfdsfsd")

        mPresenter= RegisterPresenter()
        mPresenter.mView=this
     button.setOnClickListener { mPresenter.register("dfsf","fdsfds") }
    }
}