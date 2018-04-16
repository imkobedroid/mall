package mall.kotlin.com.baselibrary.injection.component

import android.content.Context
import dagger.Component
import mall.kotlin.com.baselibrary.injection.module.AppModule
import javax.inject.Singleton

/**
 * @author Dsh  on 2018/4/16.
 */
@Singleton
@Component(modules = [(AppModule::class)])
interface AppComponent {
    fun context():Context
}