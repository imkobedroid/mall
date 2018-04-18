package com.kotlin.usercenter.service

import com.kotlin.usercenter.ui.ServiceBean
import io.reactivex.Flowable

/**
 * @author Dsh toushihiroshi on 2018/4/12.
 */
interface UserService {
    fun register(mobile:String,code:String,pwd:String):Flowable<Boolean>


    fun questService(app_id: String,
                     nonce: String,
                     sign: String,
                     method: String,
                     uid: String):Flowable<ServiceBean>
}