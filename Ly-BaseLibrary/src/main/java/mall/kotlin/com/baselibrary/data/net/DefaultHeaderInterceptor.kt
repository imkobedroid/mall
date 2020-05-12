package mall.kotlin.com.baselibrary.data.net

import mall.kotlin.com.baselibrary.common.BaseApplication.Companion.applicationContext
import mall.kotlin.com.baselibrary.common.ResultCode.Companion.requestDeviceId
import okhttp3.Interceptor
import okhttp3.Response

/**
 * @author Dsh  imkobedroid@gmail.com
 * @date 2020/5/12
 */

class DefaultHeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request().newBuilder()
                .addHeader("platform", "OPEN_MUSIC")
                .addHeader("appId", "aiplayer")
                .addHeader("mac", requestDeviceId(applicationContext))
                .build()
        return chain.proceed(original)
    }
}