package com.kotlin.usercenter.ui

import android.annotation.SuppressLint
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.kotlin.provider.common.ProviderConstant.Companion.PATH
import com.kotlin.usercenter.R
import com.kotlin.usercenter.data.protocol.LoginInfo
import com.kotlin.usercenter.injection.component.DaggerUserComponent
import com.kotlin.usercenter.injection.module.UserModule
import com.kotlin.usercenter.presenter.LoginPresenter
import com.kotlin.usercenter.presenter.view.LoginView
import kotlinx.android.synthetic.main.activity_login.*
import mall.kotlin.com.baselibrary.ui.activity.BaseMvpActivity
import org.jetbrains.anko.toast


/**
 * @author Dsh  imkobedroid@gmail.com
 * @date 2020/5/12
 */
@SuppressLint("Registered")
@Route(path = PATH)
class LoginActivity : BaseMvpActivity<LoginPresenter>(), LoginView {


    override fun loginResult(b: List<LoginInfo>) {
        toast("请求成功")
    }


    override fun injectComponent() {
        DaggerUserComponent.builder().activityComponent(activityComponent)
                .userModule(UserModule()).build().inject(this)
        mPresenter.mView = this
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initView()
    }


    private fun initView() {

        mLoginBtn.setOnClickListener {
            mPresenter.login(mMobileEt.text.toString())
        }
    }

}