package mall.kotlin.com.baselibrary.injection.component

import android.app.Activity
import dagger.Component
import mall.kotlin.com.baselibrary.injection.ActivityScope
import mall.kotlin.com.baselibrary.injection.module.ActivityModule

/**
 * @author Dsh  on 2018/4/16.
 */

@ActivityScope
@Component(modules = [(ActivityModule::class)], dependencies = [(AppComponent::class)])
interface ActivityComponent {

    fun activity(): Activity
}