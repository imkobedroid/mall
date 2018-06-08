package mall.kotlin.com.ordercenter.service

import io.reactivex.Flowable
import mall.kotlin.com.ordercenter.data.protocol.Order
import rx.Observable

/*
    订单业务 接口
 */
interface OrderService {

    /*
       根据ID查询订单
    */
    fun getOrderById(orderId: Int): Flowable<Order>

    /*
    提交订单
 */
    fun submitOrder(order: Order): Flowable<Boolean>

    /*
    根据状态查询订单列表
 */
    fun getOrderList(orderStatus: Int): Flowable<MutableList<Order>?>

    /*
    取消订单
 */
    fun cancelOrder(orderId: Int): Flowable<Boolean>

    /*
        确认订单
     */
    fun confirmOrder(orderId: Int): Flowable<Boolean>
}
