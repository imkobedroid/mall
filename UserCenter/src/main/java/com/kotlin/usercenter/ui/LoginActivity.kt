package com.kotlin.usercenter.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import com.kotlin.usercenter.R
import com.kotlin.usercenter.data.protocol.UserInfo
import com.kotlin.usercenter.injection.component.DaggerUserComponent
import com.kotlin.usercenter.injection.module.UserModule
import com.kotlin.usercenter.presenter.LoginPresenter
import com.kotlin.usercenter.presenter.view.LoginView
import kotlinx.android.synthetic.main.activity_login.*
import mall.kotlin.com.baselibrary.ext.enable
import mall.kotlin.com.baselibrary.ui.activity.BaseMvpActivity
import org.jetbrains.anko.toast

@SuppressLint("Registered")
class LoginActivity : BaseMvpActivity<LoginPresenter>(), LoginView, View.OnClickListener {
    override fun loginResult(b: UserInfo) {
        toast(b.userMobile)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.mLoginBtn -> {
               mPresenter.login(mMobileEt.text.toString(),mPwdEt.text.toString(),"")
            }
        }
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


    /**
     * 初始化视图
     */
    private fun initView() {
        mLoginBtn.enable(mMobileEt, { isBtnEnable() })
        mLoginBtn.enable(mPwdEt, { isBtnEnable() })
        mLoginBtn.setOnClickListener(this)
    }

    private fun isBtnEnable(): Boolean {
        return mMobileEt.text.isNullOrEmpty().not() and
                mMobileEt.text.isNullOrEmpty().not()
    }
}