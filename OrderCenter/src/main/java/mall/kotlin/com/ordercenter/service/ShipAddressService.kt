package mall.kotlin.com.ordercenter.service

import io.reactivex.Flowable
import mall.kotlin.com.ordercenter.data.protocol.ShipAddress
import rx.Observable

/*
    收货人信息 业务接口
 */
interface ShipAddressService {

    /*
        添加收货地址
     */
    fun addShipAddress(shipUserName: String, shipUserMobile: String, shipAddress: String): Flowable<Boolean>

    /*
    获取收货地址列表
 */
    fun getShipAddressList(): Flowable<MutableList<ShipAddress>?>

    /*
     修改收货地址
  */
    fun editShipAddress(address: ShipAddress): Flowable<Boolean>

    /*
    删除收货地址
 */
    fun deleteShipAddress(id: Int): Flowable<Boolean>

}
