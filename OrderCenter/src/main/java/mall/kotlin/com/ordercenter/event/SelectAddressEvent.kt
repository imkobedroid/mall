package mall.kotlin.com.ordercenter.event

import mall.kotlin.com.ordercenter.data.protocol.ShipAddress

/*
    选择收货人信息事件
 */
class SelectAddressEvent(val address: ShipAddress)
