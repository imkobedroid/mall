package mall.kotlin.com.baselibrary.injection.component

import android.content.Context
import dagger.Component
import mall.kotlin.com.baselibrary.injection.module.AppModule
import javax.inject.Singleton

/**
 * @author Dsh  imkobedroid@gmail.com
 * @date 2020/5/12
 */
@Singleton
@Component(modules = [(AppModule::class)])
interface AppComponent {
    fun context():Context
}