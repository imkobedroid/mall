package mall.kotlin.com.baselibrary.injection.module

import android.app.Activity
import dagger.Module
import dagger.Provides

/**
 * @author Dsh  imkobedroid@gmail.com
 * @date 2020/5/12
 */

@Module
class ActivityModule(private val activity:Activity) {

    @Provides
    fun providesActivity(): Activity {
        return activity
    }
}