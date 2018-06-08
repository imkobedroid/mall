package mall.kotlin.com.goodcenter.injection.component

import dagger.Component
import mall.kotlin.com.baselibrary.injection.PerComponentScope
import mall.kotlin.com.baselibrary.injection.component.ActivityComponent
import mall.kotlin.com.goodcenter.injection.module.CartModule
import mall.kotlin.com.goodcenter.injection.module.CategoryModule
import mall.kotlin.com.goodcenter.ui.activity.GoodsActivity
import mall.kotlin.com.goodcenter.ui.activity.GoodsDetailActivity
import mall.kotlin.com.goodcenter.ui.fragment.CartFragment
import mall.kotlin.com.goodcenter.ui.fragment.CategoryFragment
import mall.kotlin.com.goodcenter.ui.fragment.GoodsTabOneFragment

/**
 * @author Dsh  on 2018/4/16.
 */

@PerComponentScope
@Component(modules = [(CartModule::class)], dependencies = [(ActivityComponent::class)])
interface CartComponent {
    fun inject(fragment: CartFragment)
}