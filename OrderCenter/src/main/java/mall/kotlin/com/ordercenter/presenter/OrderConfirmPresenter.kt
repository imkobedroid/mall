package mall.kotlin.com.ordercenter.presenter

import mall.kotlin.com.baselibrary.ext.execute
import mall.kotlin.com.ordercenter.service.OrderService
import mall.kotlin.com.baselibrary.presenter.BasePresenter
import mall.kotlin.com.baselibrary.rx.BaseSubscribe
import mall.kotlin.com.ordercenter.data.protocol.Order
import mall.kotlin.com.ordercenter.presenter.view.OrderConfirmView
import javax.inject.Inject

/*
    订单确认页 Presenter
 */
class OrderConfirmPresenter @Inject constructor() : BasePresenter<OrderConfirmView>() {

    @Inject
    lateinit var orderService: OrderService

    /*
        根据ID获取订单
     */
    fun getOrderById(orderId: Int) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        orderService.getOrderById(orderId).execute(object : BaseSubscribe<Order>(mView) {
            override fun onNext(t: Order) {
                    mView.onGetOrderByIdResult(t)
            }
        }, lifecycleProvider)

    }

    /*
        提交订单
     */
    fun submitOrder(order: Order) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        orderService.submitOrder(order).execute(object : BaseSubscribe<Boolean>(mView) {
            override fun onNext(t: Boolean) {
                mView.onSubmitOrderResult(t)
            }
        }, lifecycleProvider)

    }


}
