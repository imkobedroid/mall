package com.kotlin.usercenter.service

import io.reactivex.Flowable

/**
 * @author Dsh  on 2018/4/12.
 */
interface UploadService {
    fun getUploadToken(): Flowable<String>
}