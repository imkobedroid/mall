package com.kotlin.usercenter.injection.module

import com.kotlin.usercenter.service.UploadService
import com.kotlin.usercenter.service.impl.UploadServiceImpl
import com.kotlin.usercenter.service.impl.UserServiceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Named

/**
 * @author Dsh  on 2018/4/16.
 */

@Module
class UpLoadModule {

    @Provides
    @Named("upload_service")
    fun providesUserService(service: UploadServiceImpl): UploadService {
        return service
    }
}