package com.kotlin.usercenter.ui

import android.Manifest
import android.os.Bundle
import com.kotlin.usercenter.R
import com.kotlin.usercenter.presenter.RegisterPresenter
import com.kotlin.usercenter.presenter.view.RegisterView
import com.tbruyelle.rxpermissions2.RxPermissions
import kotlinx.android.synthetic.main.login.*
import mall.kotlin.com.baselibrary.ui.activity.BaseMvpActivity
import org.jetbrains.anko.toast

class MainActivity : BaseMvpActivity<RegisterPresenter>(), RegisterView {
    override fun registerResult(b: Boolean) {
        if (b) toast("注册成功") else toast("注册失败")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        mPresenter.mView = this
        button.setOnClickListener {
            RxPermissions(this).request(Manifest.permission.INTERNET).subscribe {
                if (it) {
                    mPresenter.register("15608073947", "1111", "930529")
                }
            }
        }

    }
}