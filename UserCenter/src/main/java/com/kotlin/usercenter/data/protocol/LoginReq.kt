package com.kotlin.usercenter.data.protocol

import java.io.Serializable

/**
 * @author Dsh  imkobedroid@gmail.com
 * @date 2020/5/12
 */
data class LoginInfo(
        var isSelect: Boolean = false,
        val intro: String,
        val isLogin: Int,
        val name: String,
        val pc: Int,
        val regionCode: String,
        val screenStatus: Int,
        val serialNumber: String,
        val web: Int
) : Serializable