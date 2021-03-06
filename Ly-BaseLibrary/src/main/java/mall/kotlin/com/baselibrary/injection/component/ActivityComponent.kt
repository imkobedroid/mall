package mall.kotlin.com.baselibrary.injection.component

import android.app.Activity
import android.content.Context
import com.trello.rxlifecycle3.LifecycleProvider
import dagger.Component
import mall.kotlin.com.baselibrary.injection.ActivityScope
import mall.kotlin.com.baselibrary.injection.module.ActivityModule
import mall.kotlin.com.baselibrary.injection.module.LifecycleProviderModule

/**
 * @author Dsh  imkobedroid@gmail.com
 * @date 2020/5/12
 */

@ActivityScope
@Component(modules = [(ActivityModule::class), (LifecycleProviderModule::class)], dependencies = [(AppComponent::class)])
interface ActivityComponent {

    fun activity(): Activity

    fun lifecycle(): LifecycleProvider<*>

    fun context():Context
}