package mall.kotlin.com.ordercenter.data.repository
import io.reactivex.Flowable
import mall.kotlin.com.ordercenter.data.api.ShipAddressApi
import javax.inject.Inject
import rx.Observable
import mall.kotlin.com.ordercenter.data.protocol.ShipAddress
import mall.kotlin.com.baselibrary.data.net.RetrofitFactory
import mall.kotlin.com.baselibrary.data.protocol.BaseResp
import mall.kotlin.com.ordercenter.data.protocol.AddShipAddressReq
import mall.kotlin.com.ordercenter.data.protocol.DeleteShipAddressReq
import mall.kotlin.com.ordercenter.data.protocol.EditShipAddressReq


/*
   收货地址数据层
 */
class ShipAddressRepository @Inject constructor() {

    /*
        添加收货地址
     */
    fun addShipAddress(shipUserName: String, shipUserMobile: String, shipAddress: String): Flowable<BaseResp<String>> {
        return RetrofitFactory.instance.createApi(ShipAddressApi::class.java).addShipAddress(AddShipAddressReq(shipUserName,shipUserMobile,shipAddress))
    }

    /*
        删除收货地址
     */
    fun deleteShipAddress(id: Int): Flowable<BaseResp<String>> {
        return RetrofitFactory.instance.createApi(ShipAddressApi::class.java).deleteShipAddress(DeleteShipAddressReq(id))
    }

    /*
        修改收货地址
     */
    fun editShipAddress(address: ShipAddress): Flowable<BaseResp<String>> {
        return RetrofitFactory.instance.createApi(ShipAddressApi::class.java).editShipAddress(EditShipAddressReq(address.id,address.shipUserName,address.shipUserMobile,address.shipAddress,address.shipIsDefault))
    }

    /*
        获取收货地址列表
     */
    fun getShipAddressList(): Flowable<BaseResp<MutableList<ShipAddress>?>> {
        return RetrofitFactory.instance.createApi(ShipAddressApi::class.java).getShipAddressList()
    }

}
