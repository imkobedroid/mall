package com.kotlin.usercenter.ui

import android.Manifest
import android.os.Bundle
import com.kotlin.usercenter.R
import com.kotlin.usercenter.injection.component.DaggerUserComponent
import com.kotlin.usercenter.injection.module.UserModule
import com.kotlin.usercenter.presenter.RegisterPresenter
import com.kotlin.usercenter.presenter.view.RegisterView
import com.tbruyelle.rxpermissions2.RxPermissions
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.login.*
import mall.kotlin.com.baselibrary.ext.onClick
import mall.kotlin.com.baselibrary.injection.component.ActivityComponent
import mall.kotlin.com.baselibrary.ui.activity.BaseMvpActivity
import org.jetbrains.anko.toast

class MainActivity : BaseMvpActivity<RegisterPresenter>(), RegisterView {
    override fun getService(b: ServiceBean) {
        toast("服务器个数为${b.configs.size}")
    }

    override fun injectComponent() {
        DaggerUserComponent.builder().activityComponent(activityComponent)
                .userModule(UserModule()).build().inject(this)
        mPresenter.mView = this
    }

    override fun registerResult(b: Boolean) {
        if (b) toast("注册成功") else toast("注册失败")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
        button.setOnClickListener {
            RxPermissions(this).request(Manifest.permission.INTERNET).subscribe {
                if (it) {
                    mPresenter.getService("08ccx61c-b257-1xe5-d20b-h7b1gc5f1d2h", "5", "701b4f5f746b4d48", "vpn.list", "1")
                }
            }

        }

        button.onClick {
            RxPermissions(this).request(Manifest.permission.INTERNET).subscribe {
                if (it) {
                    mPresenter.getService("08ccx61c-b257-1xe5-d20b-h7b1gc5f1d2h", "5", "701b4f5f746b4d48", "vpn.list", "1")
                }
            }
            true
        }
    }
}