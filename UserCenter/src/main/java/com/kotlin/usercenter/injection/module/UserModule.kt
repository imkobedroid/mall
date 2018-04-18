package com.kotlin.usercenter.injection.module

import com.kotlin.usercenter.service.UserService
import com.kotlin.usercenter.service.impl.UserServiceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Named

/**
 * @author Dsh  on 2018/4/16.
 */

@Module
class UserModule {

    @Provides
    @Named("service")
    fun providesUserService(service: UserServiceImpl): UserService {
        return service
    }

}