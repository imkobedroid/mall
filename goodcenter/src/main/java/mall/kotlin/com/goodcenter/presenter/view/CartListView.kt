package mall.kotlin.com.goodcenter.presenter.view

import mall.kotlin.com.baselibrary.presenter.view.BaseView
import mall.kotlin.com.goodcenter.date.protocol.CartGoods

/**
 * @author Dsh toushihiroshi on 2018/6/6.
 */
interface CartListView : BaseView {

    //获取购物车列表
    fun onGetCartListResult(result: MutableList<CartGoods>?)
    //删除购物车
    fun onDeleteCartListResult(result: Boolean)
    //提交购物车
    fun onSubmitCartListResult(result: Int)
}
