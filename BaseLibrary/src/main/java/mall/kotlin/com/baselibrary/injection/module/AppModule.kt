package mall.kotlin.com.baselibrary.injection.module

import android.app.Activity
import android.content.Context
import dagger.Module
import dagger.Provides
import mall.kotlin.com.baselibrary.common.BaseApplication
import javax.inject.Singleton

/**
 * @author Dsh  on 2018/4/16.
 */

@Module
class AppModule(private val context:BaseApplication) {

    @Provides
    fun providesContext(): Context {
        return context
    }
}