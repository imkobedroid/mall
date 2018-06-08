
import mall.kotlin.com.ordercenter.injection.module.ShipAddressModule
import mall.kotlin.com.ordercenter.ui.activity.ShipAddressActivity
import com.kotlin.order.ui.activity.ShipAddressEditActivity
import dagger.Component
import mall.kotlin.com.baselibrary.injection.PerComponentScope
import mall.kotlin.com.baselibrary.injection.component.ActivityComponent

/*
    收货人信息Component
 */
@PerComponentScope
@Component(dependencies = [(ActivityComponent::class)],modules = [(ShipAddressModule::class)])
interface ShipAddressComponent {
    fun inject(activity: ShipAddressEditActivity)
    fun inject(activity: ShipAddressActivity)
}
