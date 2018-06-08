package mall.kotlin.com.ordercenter.data.api

import io.reactivex.Flowable
import mall.kotlin.com.baselibrary.data.protocol.BaseResp
import mall.kotlin.com.ordercenter.data.protocol.*
import retrofit2.http.Body
import retrofit2.http.POST


/*
    订单 接口
 */
interface OrderApi {

    /*
        取消订单
     */
    @POST("order/cancel")
    fun cancelOrder(@Body req: CancelOrderReq): Flowable<BaseResp<String>>

    /*
        确认订单
     */
    @POST("order/confirm")
    fun confirmOrder(@Body req: ConfirmOrderReq): Flowable<BaseResp<String>>

    /*
        根据ID获取订单
     */
    @POST("order/getOrderById")
    fun getOrderById(@Body req: GetOrderByIdReq): Flowable<BaseResp<Order>>

    /*
        根据订单状态查询查询订单列表
     */
    @POST("order/getOrderList")
    fun getOrderList(@Body req: GetOrderListReq): Flowable<BaseResp<MutableList<Order>?>>

    /*
        提交订单
     */
    @POST("order/submitOrder")
    fun submitOrder(@Body req: SubmitOrderReq): Flowable<BaseResp<String>>

}
