package mall.kotlin.com.baselibrary.injection.module

import com.trello.rxlifecycle2.LifecycleProvider
import dagger.Module
import dagger.Provides

/**
 * @author Dsh  on 2018/4/16.
 */

@Module
class LifecycleProviderModule(private val lifecycleProvider: LifecycleProvider<*>) {

    @Provides
    fun providesLifecycle(): LifecycleProvider<*> {
        return lifecycleProvider
    }
}