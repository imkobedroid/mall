package mall.kotlin.com.baselibrary.common

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.alibaba.android.arouter.launcher.ARouter
import mall.kotlin.com.baselibrary.injection.component.AppComponent
import mall.kotlin.com.baselibrary.injection.component.DaggerAppComponent
import mall.kotlin.com.baselibrary.injection.module.AppModule

/**
 * @author Dsh  on 2018/4/16.
 */
class BaseApplication : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        initInjection()
        ARouter.openLog()
        ARouter.openDebug()
        ARouter.init(this)
        context=this
    }

    private fun initInjection() {
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context:Context
    }
}