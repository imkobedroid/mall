package mall.kotlin.com.baselibrary.data.net

import mall.kotlin.com.baselibrary.common.BaseConstance
import mall.kotlin.com.baselibrary.utils.RxUtils
import mall.kotlin.com.baselibrary.utils.TrustAllCerts
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


/**
 * @author Dsh  imkobedroid@gmail.com
 * @date 2020/5/12
 */

class RetrofitFactory private constructor() {

    companion object {
        val instance: RetrofitFactory by lazy { RetrofitFactory() }
    }

    private val retrofit: Retrofit
    private val interceptor: Interceptor

    init {
        interceptor = DefaultHeaderInterceptor()


        retrofit = Retrofit.Builder().baseUrl(BaseConstance.BASE_URL)
                .client(initClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

    private fun initClient(): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(initLogInterceptor())
                .addInterceptor(interceptor)
                .connectTimeout(BaseConstance.TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(BaseConstance.TIME_OUT, TimeUnit.SECONDS)
                .hostnameVerifier(RxUtils.TrustAllHostnameVerifier())
                .sslSocketFactory(RxUtils.createSSLSocketFactory(), TrustAllCerts())
                .retryOnConnectionFailure(true)
                .build()
    }

    private fun initLogInterceptor(): Interceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        return interceptor
    }


    fun <T> createApi(api: Class<T>): T {
        return retrofit.create(api)
    }

}