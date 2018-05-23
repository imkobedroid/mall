package com.kotlin.usercenter.ui

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.support.annotation.RequiresApi
import android.view.View
import com.bigkoo.alertview.AlertView
import com.bigkoo.alertview.OnItemClickListener
import com.jph.takephoto.app.TakePhoto
import com.jph.takephoto.app.TakePhotoImpl
import com.jph.takephoto.model.TResult
import com.kotlin.usercenter.R
import com.kotlin.usercenter.injection.component.DaggerUserComponent
import com.kotlin.usercenter.injection.module.UserModule
import com.kotlin.usercenter.presenter.UserInfoPresenter
import com.kotlin.usercenter.presenter.view.UserInfoView
import com.qiniu.android.storage.UploadManager
import com.tbruyelle.rxpermissions2.RxPermissions
import kotlinx.android.synthetic.main.activity_user_info.*
import mall.kotlin.com.baselibrary.common.BaseConstance
import mall.kotlin.com.baselibrary.ui.activity.BaseMvpActivity
import mall.kotlin.com.baselibrary.utils.DateUtils
import mall.kotlin.com.baselibrary.utils.GlideUtils
import org.jetbrains.anko.toast
import java.io.File

@SuppressLint("Registered")
class UserInfoActivity : BaseMvpActivity<UserInfoPresenter>(), UserInfoView, View.OnClickListener, TakePhoto.TakeResultListener {


    private lateinit var mTakePhoto: TakePhoto
    private lateinit var mTempFile: File
    private lateinit var rxPermission: RxPermissions
    private var mLocalFile: String? = null
    private var mRemoteFile: String? = null
    private val mUploadManager: UploadManager by lazy { UploadManager() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_info)
        mTakePhoto = TakePhotoImpl(this, this)
        mTakePhoto.onCreate(savedInstanceState)
        rxPermission = RxPermissions(this)
        initView()
    }


    /**
     * 初始化视图
     */
    private fun initView() {
        mUserIconView.setOnClickListener(this)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        mTakePhoto.onActivityResult(requestCode, resultCode, data)
    }

    private fun createTempFile() {
        val tempFileName = "${DateUtils.curTime}.png"
        if (Environment.MEDIA_MOUNTED == Environment.getExternalStorageState()) {
            this.mTempFile = File(Environment.getExternalStorageDirectory(), tempFileName)
            return
        }
        this.mTempFile = File(filesDir, tempFileName)
    }


    override fun onGetUploadTokenResult(result: String) {
        mUploadManager.put(mLocalFile, null, result, { _, _, json ->
            mRemoteFile = BaseConstance.IMAGE_SERVER_ADDRESS + json?.get("hash")
            GlideUtils.loadUrlImage(this@UserInfoActivity, mRemoteFile!!, mUserIconIv)
        }, null)
    }

    override fun takeSuccess(result: TResult?) {
        mLocalFile = result?.image?.originalPath
        mPresenter.getUploadToken()
    }

    override fun takeCancel() {
        toast("取消")
    }

    override fun takeFail(result: TResult?, msg: String?) {
        msg?.let { toast(msg) }
    }

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.mUserIconView -> showAlertView()
        }
    }

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    private fun showAlertView() {
        AlertView("选择图片", "", "取消", null, arrayOf("拍照", "相册"), this
                , AlertView.Style.ActionSheet, OnItemClickListener { _, position ->
            //mTakePhoto.onEnableCompress(CompressConfig.ofDefaultConfig(), false)
            when (position) {
                0 -> {
                    rxPermission.request(Manifest.permission.CAMERA).subscribe {
                        createTempFile()
                        mTakePhoto.onPickFromCapture(Uri.fromFile(mTempFile))
                    }
                }
                1 ->
                    rxPermission.request(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE).subscribe {
                        mTakePhoto.onPickFromGallery()
                    }
            }
        }).show()
    }


    override fun injectComponent() {
        DaggerUserComponent.builder().activityComponent(activityComponent)
                .userModule(UserModule()).build().inject(this)
        mPresenter.mView = this
    }

}