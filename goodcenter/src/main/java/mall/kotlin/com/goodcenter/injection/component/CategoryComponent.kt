package mall.kotlin.com.goodcenter.injection.component

import dagger.Component
import mall.kotlin.com.baselibrary.injection.PerComponentScope
import mall.kotlin.com.baselibrary.injection.component.ActivityComponent
import mall.kotlin.com.goodcenter.injection.module.CategoryModule
import mall.kotlin.com.goodcenter.ui.activity.GoodsActivity
import mall.kotlin.com.goodcenter.ui.fragment.CategoryFragment

/**
 * @author Dsh  on 2018/4/16.
 */

@PerComponentScope
@Component(modules = [(CategoryModule::class)], dependencies = [(ActivityComponent::class)])
interface CategoryComponent {
    fun inject(fragment: CategoryFragment)
    fun inject(fragment: GoodsActivity)
}