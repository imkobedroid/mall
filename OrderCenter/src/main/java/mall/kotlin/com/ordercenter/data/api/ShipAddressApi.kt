package mall.kotlin.com.ordercenter.data.api

import io.reactivex.Flowable
import mall.kotlin.com.baselibrary.data.protocol.BaseResp
import mall.kotlin.com.ordercenter.data.protocol.AddShipAddressReq
import mall.kotlin.com.ordercenter.data.protocol.DeleteShipAddressReq
import mall.kotlin.com.ordercenter.data.protocol.EditShipAddressReq
import mall.kotlin.com.ordercenter.data.protocol.ShipAddress
import retrofit2.http.Body
import retrofit2.http.POST


/*
    地址管理 接口
 */
interface ShipAddressApi {

    /*
        添加收货地址
     */
    @POST("shipAddress/add")
    fun addShipAddress(@Body req: AddShipAddressReq): Flowable<BaseResp<String>>

    /*
        删除收货地址
     */
    @POST("shipAddress/delete")
    fun deleteShipAddress(@Body req: DeleteShipAddressReq): Flowable<BaseResp<String>>

    /*
        修改收货地址
     */
    @POST("shipAddress/modify")
    fun editShipAddress(@Body req: EditShipAddressReq): Flowable<BaseResp<String>>

    /*
        查询收货地址列表
     */
    @POST("shipAddress/getList")
    fun getShipAddressList(): Flowable<BaseResp<MutableList<ShipAddress>?>>

}
