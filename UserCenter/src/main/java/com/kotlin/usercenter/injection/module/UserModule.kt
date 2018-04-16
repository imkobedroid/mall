package com.kotlin.usercenter.injection.module

import com.kotlin.usercenter.service.UserService
import com.kotlin.usercenter.service.impl.UserServiceImpl
import dagger.Module
import dagger.Provides

/**
 * @author Dsh  on 2018/4/16.
 */

@Module
class UserModule {

    @Provides
    fun providesUserService(service: UserServiceImpl): UserService {
        return service
    }

}