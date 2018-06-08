package mall.kotlin.com.ordercenter.injection.module

import mall.kotlin.com.ordercenter.service.OrderService
import mall.kotlin.com.ordercenter.service.impl.OrderServiceImpl
import dagger.Module
import dagger.Provides

/*
    订单Module
 */
@Module
class OrderModule {

    @Provides
    fun provideOrderservice(orderService: OrderServiceImpl): OrderService {
        return orderService
    }

}
