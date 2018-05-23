package com.kotlin.usercenter.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import com.kotlin.usercenter.R
import com.kotlin.usercenter.injection.component.DaggerUserComponent
import com.kotlin.usercenter.injection.module.UserModule
import com.kotlin.usercenter.presenter.ResetPwdPresenter
import com.kotlin.usercenter.presenter.view.ResetPwdView
import kotlinx.android.synthetic.main.activity_reset_pwd.*
import mall.kotlin.com.baselibrary.ext.enable
import mall.kotlin.com.baselibrary.ui.activity.BaseMvpActivity
import org.jetbrains.anko.toast

@SuppressLint("Registered")
class ResetPwdActivity : BaseMvpActivity<ResetPwdPresenter>(), ResetPwdView, View.OnClickListener {
    override fun resetPwdResult(b: Boolean) {
        if (b) finish()
    }

    override fun onClick(v: View?) {
        when (v?.id) {

            R.id.mConfirmBtn -> {
                if (mPwdEt.text.toString() != mPwdConfirmEt.text.toString()) {
                    toast("两次输入不同")
                }
                mPresenter.resetPwd(intent.getStringExtra("mobile"), mPwdEt.text.toString())
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
        setContentView(R.layout.activity_reset_pwd)
        initView()
    }


    /**
     * 初始化视图
     */
    private fun initView() {

        mConfirmBtn.enable(mPwdEt, { isBtnEnable() })
        mConfirmBtn.enable(mPwdConfirmEt, { isBtnEnable() })
        mConfirmBtn.setOnClickListener(this)
    }


    private fun isBtnEnable(): Boolean {
        return mPwdEt.text.isNullOrEmpty().not() and
                mPwdConfirmEt.text.isNullOrEmpty().not()
    }
}