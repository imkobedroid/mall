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
import mall.kotlin.com.baselibrary.common.AppManager
import mall.kotlin.com.baselibrary.ext.onClick
import mall.kotlin.com.baselibrary.injection.component.ActivityComponent
import mall.kotlin.com.baselibrary.ui.activity.BaseMvpActivity
import mall.kotlin.com.baselibrary.widgets.VerifyButton
import org.jetbrains.anko.toast

class MainActivity : BaseMvpActivity<RegisterPresenter>(), RegisterView {


    private var time: Long = 0


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
            //showLoading()
            RxPermissions(this).request(Manifest.permission.INTERNET).subscribe {
                 mPresenter.register(account.text.toString(),code.text.toString(),password.text.toString())
            }

        }



        questCode.setOnVerifyBtnClick(object : VerifyButton.OnVerifyBtnClick{
            override fun onClick() {
                toast("获取验证码")
            }

        })

        questCode.setOnClickListener { questCode.requestSendVerifyNumber() }

    }

    /**
     * 测试双击退出
     */
    override fun onBackPressed() {
        val time1 = System.currentTimeMillis()
        if (time1 - time > 2000) {
            toast("再按一次退出")
            time = time1
        } else {
            AppManager.instance.finishAllActivity()
        }
    }
}