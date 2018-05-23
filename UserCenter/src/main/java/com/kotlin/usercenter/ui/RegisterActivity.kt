package com.kotlin.usercenter.ui

import android.Manifest
import android.os.Bundle
import android.view.View
import com.kotlin.usercenter.R
import com.kotlin.usercenter.injection.component.DaggerUserComponent
import com.kotlin.usercenter.injection.module.UserModule
import com.kotlin.usercenter.presenter.RegisterPresenter
import com.kotlin.usercenter.presenter.view.RegisterView
import com.tbruyelle.rxpermissions2.RxPermissions
import kotlinx.android.synthetic.main.activity_register.*
import mall.kotlin.com.baselibrary.common.AppManager
import mall.kotlin.com.baselibrary.ext.enable
import mall.kotlin.com.baselibrary.ui.activity.BaseMvpActivity
import org.jetbrains.anko.toast

class RegisterActivity : BaseMvpActivity<RegisterPresenter>(), RegisterView, View.OnClickListener {

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.mVerifyCodeBtn -> {
                mVerifyCodeBtn.requestSendVerifyNumber()
                toast("发送验证码成功")
            }

            R.id.mRegisterBtn ->{
                RxPermissions(this).request(Manifest.permission.INTERNET).subscribe {
                    mPresenter.register(mMobileEt.text.toString(), mVerifyCodeEt.text.toString(), mPwdEt.text.toString())
                }
            }
        }
    }

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
        setContentView(R.layout.activity_register)
        initView()
    }


    /**
     * 初始化视图
     */
    private fun initView() {

        mRegisterBtn.enable(mMobileEt,{isBtnEnable()})
        mRegisterBtn.enable(mPwdConfirmEt,{isBtnEnable()})
        mRegisterBtn.enable(mPwdEt,{isBtnEnable()})
        mRegisterBtn.enable(mVerifyCodeEt,{isBtnEnable()})

        mRegisterBtn.setOnClickListener(this)
        mVerifyCodeBtn.setOnClickListener(this)
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

    private fun isBtnEnable():Boolean{
        return  mMobileEt.text.isNullOrEmpty().not() and
                mVerifyCodeBtn.text.isNullOrEmpty().not() and
                mMobileEt.text.isNullOrEmpty().not() and
                mPwdConfirmEt.text.isNullOrEmpty().not()
    }
}