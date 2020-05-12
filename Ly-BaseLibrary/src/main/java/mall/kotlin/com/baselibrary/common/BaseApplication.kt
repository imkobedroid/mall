package mall.kotlin.com.baselibrary.common

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.alibaba.android.arouter.launcher.ARouter
import mall.kotlin.com.baselibrary.BuildConfig
import mall.kotlin.com.baselibrary.injection.component.AppComponent
import mall.kotlin.com.baselibrary.injection.component.DaggerAppComponent
import mall.kotlin.com.baselibrary.injection.module.AppModule

/**
 * @author Dsh  imkobedroid@gmail.com
 * @date 2020/5/12
 */
class BaseApplication : Application() {

    lateinit var appComponent: AppComponent


    override fun onCreate() {
        super.onCreate()
        initInjection()
        context = this
        BaseApplication.applicationContext = applicationContext
    }

    private fun initInjection() {
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
        if (BuildConfig.DEBUG) {
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(this)
    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
        lateinit var applicationContext: Context

    }
}