package mall.kotlin.com.ordercenter.injection.module

import mall.kotlin.com.ordercenter.service.ShipAddressService
import mall.kotlin.com.ordercenter.service.impl.ShipAddressServiceImpl
import dagger.Module
import dagger.Provides

/*
    收货人信息Module
 */
@Module
class ShipAddressModule {

    @Provides
    fun provideShipAddressservice(shipAddressService: ShipAddressServiceImpl): ShipAddressService {
        return shipAddressService
    }

}
