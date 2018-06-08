package mall.kotlin.com.ordercenter.service.impl

import io.reactivex.Flowable
import mall.kotlin.com.baselibrary.ext.convert
import mall.kotlin.com.baselibrary.ext.convertBoolean
import mall.kotlin.com.ordercenter.service.OrderService
import mall.kotlin.com.ordercenter.data.protocol.Order
import mall.kotlin.com.ordercenter.data.repository.OrderRepository
import rx.Observable
import javax.inject.Inject

/*
    订单业务实现类
 */
class OrderServiceImpl @Inject constructor(): OrderService {

    @Inject
    lateinit var repository: OrderRepository

    /*
        根据ID查询订单
     */
    override fun getOrderById(orderId: Int): Flowable<Order> {
        return repository.getOrderById(orderId).convert()
    }

    /*
        订单确认，提交订单
     */
    override fun submitOrder(order: Order): Flowable<Boolean> {
        return repository.submitOrder(order).convertBoolean()
    }

    /*
        根据订单状态获取订单列表
     */
    override fun getOrderList(orderStatus: Int): Flowable<MutableList<Order>?> {
        return repository.getOrderList(orderStatus).convert()

    }

    /*
        取消订单
     */
    override fun cancelOrder(orderId: Int): Flowable<Boolean> {
        return repository.cancelOrder(orderId).convertBoolean()
    }

    /*
        订单确认收货
     */
    override fun confirmOrder(orderId: Int): Flowable<Boolean> {
        return repository.confirmOrder(orderId).convertBoolean()
    }
}
