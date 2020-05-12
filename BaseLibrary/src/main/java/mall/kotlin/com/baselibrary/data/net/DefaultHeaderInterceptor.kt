package mall.kotlin.com.baselibrary.data.net

import okhttp3.Interceptor
import okhttp3.Response

/**
 * @author Dsh  imkobedroid@gmail.com
 * @date 2020/5/12
 */

class DefaultHeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request().newBuilder()
                .addHeader("Content-Type", "application/json")
                .addHeader("charset", "utf-8")
                .addHeader("token", "")
                .build()
        return chain.proceed(original)
    }
}