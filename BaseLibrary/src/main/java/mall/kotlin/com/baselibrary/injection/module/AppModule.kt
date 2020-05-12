package mall.kotlin.com.baselibrary.injection.module

import android.content.Context
import dagger.Module
import dagger.Provides
import mall.kotlin.com.baselibrary.common.BaseApplication

/**
 * @author Dsh  imkobedroid@gmail.com
 * @date 2020/5/12
 */
@Module
class AppModule(private val context:BaseApplication) {

    @Provides
    fun providesContext(): Context {
        return context
    }
}