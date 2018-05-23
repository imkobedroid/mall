package com.kotlin.usercenter.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import com.kotlin.usercenter.R
import com.kotlin.usercenter.injection.component.DaggerUserComponent
import com.kotlin.usercenter.injection.module.UserModule
import com.kotlin.usercenter.presenter.ForgetPwdPresenter
import com.kotlin.usercenter.presenter.view.ForgetPwdView
import kotlinx.android.synthetic.main.activity_forget_pwd.*
import mall.kotlin.com.baselibrary.ext.enable
import mall.kotlin.com.baselibrary.ui.activity.BaseMvpActivity
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

@SuppressLint("Registered")
class ForgetPwdActivity : BaseMvpActivity<ForgetPwdPresenter>(), ForgetPwdView, View.OnClickListener {
    override fun forgetPwdResult(b: Boolean) {
        if (b) startActivity<ResetPwdActivity>("mobile" to mMobileEt.text.toString())
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.mVerifyCodeBtn -> {
                mVerifyCodeBtn.requestSendVerifyNumber()
                toast("发送验证码成功")
            }

            R.id.mNextBtn -> mPresenter.forgetPwd(mMobileEt.text.toString(), mVerifyCodeEt.text.toString())
        }
    }

    override fun injectComponent() {
        DaggerUserComponent.builder().activityComponent(activityComponent)
                .userModule(UserModule()).build().inject(this)
        mPresenter.mView = this
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forget_pwd)
        initView()
    }


    /**
     * 初始化视图
     */
    private fun initView() {

        mNextBtn.enable(mMobileEt, { isBtnEnable() })
        mNextBtn.enable(mVerifyCodeEt, { isBtnEnable() })
        mNextBtn.setOnClickListener(this)
        mVerifyCodeBtn.setOnClickListener(this)

    }


    private fun isBtnEnable(): Boolean {
        return mMobileEt.text.isNullOrEmpty().not() and
                mVerifyCodeEt.text.isNullOrEmpty().not()
    }
}