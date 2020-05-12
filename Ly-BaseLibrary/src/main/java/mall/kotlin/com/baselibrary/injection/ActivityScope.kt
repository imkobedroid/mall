package mall.kotlin.com.baselibrary.injection

import java.lang.annotation.Documented
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy.RUNTIME
import javax.inject.Scope

/**
 * @author Dsh  imkobedroid@gmail.com
 * @date 2020/5/12
 */
@Scope
@Documented
@Retention(RUNTIME)
annotation class ActivityScope