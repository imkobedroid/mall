package mall.kotlin.com.baselibrary.injection

import java.lang.annotation.Documented
import java.lang.annotation.Retention
import javax.inject.Scope
import java.lang.annotation.RetentionPolicy.RUNTIME

/**
 * @author Dsh  on 2018/4/16.
 */
@Scope
@Documented
@Retention(RUNTIME)
annotation class ActivityScope