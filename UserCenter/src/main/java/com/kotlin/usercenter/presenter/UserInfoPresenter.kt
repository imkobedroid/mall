package com.kotlin.usercenter.presenter

import com.kotlin.usercenter.data.protocol.UserInfo
import com.kotlin.usercenter.presenter.view.UserInfoView
import com.kotlin.usercenter.service.UploadService
import com.kotlin.usercenter.service.UserService
import mall.kotlin.com.baselibrary.ext.execute
import mall.kotlin.com.baselibrary.presenter.BasePresenter
import mall.kotlin.com.baselibrary.rx.BaseSubscribe
import javax.inject.Inject
import javax.inject.Named

/**
 * @author Dsh  on 2018/4/10.
 */
open class UserInfoPresenter @Inject constructor() : BasePresenter<UserInfoView>() {

    @Inject
    @field:[Named("service")]
    lateinit var userService: UserService
    @Inject
    @field:[Named("upload_service")]
    lateinit var uploadService: UploadService


    fun getUploadToken() {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        uploadService.getUploadToken().execute(object : BaseSubscribe<String>(mView) {
            override fun onNext(t: String) {
                mView.onGetUploadTokenResult(t)
            }
        }, lifecycleProvider)
    }


    fun editUser(userIcon: String, userName: String, userGender: String, userSign: String){
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        userService.editUser(userIcon,userName,userGender,userSign).execute(object : BaseSubscribe<UserInfo>(mView) {
            override fun onNext(t: UserInfo) {
                mView.editUser(t)
            }
        }, lifecycleProvider)
    }


}