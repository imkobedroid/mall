package mall.kotlin.com.ordercenter.presenter.view

import mall.kotlin.com.baselibrary.presenter.view.BaseView

/*
    编辑收货人信息 视图回调
 */
interface EditShipAddressView : BaseView {
    //添加收货人回调
    fun onAddShipAddressResult(result: Boolean)
    //修改收货人回调
    fun onEditShipAddressResult(result: Boolean)
}
