package mall.kotlin.com.ordercenter.data.repository


import io.reactivex.Flowable
import mall.kotlin.com.baselibrary.data.net.RetrofitFactory
import mall.kotlin.com.baselibrary.data.protocol.BaseResp
import mall.kotlin.com.ordercenter.data.api.OrderApi
import mall.kotlin.com.ordercenter.data.protocol.*
import javax.inject.Inject

/*
   订单数据层
 */
class OrderRepository @Inject constructor() {

    /*
        取消订单
     */
    fun cancelOrder(orderId: Int): Flowable<BaseResp<String>> {
        return RetrofitFactory.instance.createApi(OrderApi::class.java).cancelOrder(CancelOrderReq(orderId))
    }

    /*
        确认订单
     */
    fun confirmOrder(orderId: Int): Flowable<BaseResp<String>> {
        return RetrofitFactory.instance.createApi(OrderApi::class.java).confirmOrder(ConfirmOrderReq(orderId))
    }

    /*
        根据ID查询订单
     */
    fun getOrderById(orderId: Int): Flowable<BaseResp<Order>> {
        return RetrofitFactory.instance.createApi(OrderApi::class.java).getOrderById(GetOrderByIdReq(orderId))
    }

    /*
        根据状态查询订单列表
     */
    fun getOrderList(orderStatus: Int): Flowable<BaseResp<MutableList<Order>?>> {
        return RetrofitFactory.instance.createApi(OrderApi::class.java).getOrderList(GetOrderListReq(orderStatus))
    }

    /*
        提交订单
     */
    fun submitOrder(order: Order): Flowable<BaseResp<String>> {
        return RetrofitFactory.instance.createApi(OrderApi::class.java).submitOrder(SubmitOrderReq(order))
    }

}
