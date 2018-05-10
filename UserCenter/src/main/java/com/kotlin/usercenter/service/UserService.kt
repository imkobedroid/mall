package com.kotlin.usercenter.service

import io.reactivex.Flowable

/**
 * @author Dsh  on 2018/4/12.
 */
interface UserService {
    fun register(mobile:String,code:String,pwd:String):Flowable<Boolean>
}