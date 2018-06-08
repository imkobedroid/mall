package mall.kotlin.com.ordercenter.service.impl

import io.reactivex.Flowable
import mall.kotlin.com.baselibrary.ext.convert
import mall.kotlin.com.baselibrary.ext.convertBoolean
import mall.kotlin.com.ordercenter.data.protocol.ShipAddress
import mall.kotlin.com.ordercenter.data.repository.ShipAddressRepository
import mall.kotlin.com.ordercenter.service.ShipAddressService
import javax.inject.Inject

/*
    收货人信息 业务实现类
 */
class ShipAddressServiceImpl @Inject constructor(): ShipAddressService {

    @Inject
    lateinit var repository: ShipAddressRepository

    /*
        添加收货人信息
     */
    override fun addShipAddress(shipUserName: String, shipUserMobile: String, shipAddress: String): Flowable<Boolean> {
        return repository.addShipAddress(shipUserName,shipUserMobile,shipAddress).convertBoolean()

    }

    /*
        获取收货人信息列表
     */
    override fun getShipAddressList(): Flowable<MutableList<ShipAddress>?> {
        return repository.getShipAddressList().convert()
    }

    /*
        修改收货人信息
     */
    override fun editShipAddress(address: ShipAddress): Flowable<Boolean> {
        return  repository.editShipAddress(address).convertBoolean()
    }

    /*
        删除收货人信息
     */
    override fun deleteShipAddress(id: Int): Flowable<Boolean> {
        return repository.deleteShipAddress(id).convertBoolean()
    }
}
