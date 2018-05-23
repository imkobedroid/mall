package com.kotlin.usercenter.service.impl

import com.kotlin.usercenter.data.reposiory.UploadRepository
import com.kotlin.usercenter.data.reposiory.UserRepository
import com.kotlin.usercenter.service.UploadService
import io.reactivex.Flowable
import mall.kotlin.com.baselibrary.ext.convert
import javax.inject.Inject

/**
 * @author Dsh  on 2018/4/12.
 */
class UploadServiceImpl @Inject constructor() : UploadService {
    @Inject
    lateinit var mUploadRepository: UploadRepository

    override fun getUploadToken(): Flowable<String> {
        return mUploadRepository.getUploadToken().convert()
    }
}