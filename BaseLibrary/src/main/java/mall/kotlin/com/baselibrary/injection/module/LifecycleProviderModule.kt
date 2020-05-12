package mall.kotlin.com.baselibrary.injection.module

import com.trello.rxlifecycle3.LifecycleProvider
import dagger.Module
import dagger.Provides

/**
 * @author Dsh  imkobedroid@gmail.com
 * @date 2020/5/12
 */

@Module
class LifecycleProviderModule(private val lifecycleProvider: LifecycleProvider<*>) {

    @Provides
    fun providesLifecycle(): LifecycleProvider<*> {
        return lifecycleProvider
    }
}