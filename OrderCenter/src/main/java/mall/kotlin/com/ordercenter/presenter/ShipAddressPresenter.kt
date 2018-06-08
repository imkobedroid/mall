package com.kotlin.order.presenter

import mall.kotlin.com.baselibrary.ext.execute
import mall.kotlin.com.baselibrary.presenter.BasePresenter
import mall.kotlin.com.baselibrary.rx.BaseSubscribe
import mall.kotlin.com.ordercenter.data.protocol.ShipAddress
import mall.kotlin.com.ordercenter.presenter.view.ShipAddressView
import mall.kotlin.com.ordercenter.service.ShipAddressService
import javax.inject.Inject

/*
    收货人列表Presenter
 */
class ShipAddressPresenter @Inject constructor() : BasePresenter<ShipAddressView>() {

    @Inject
    lateinit var shipAddressService: ShipAddressService

    /*
        获取收货人列表
     */
    fun getShipAddressList() {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        shipAddressService.getShipAddressList().execute(object : BaseSubscribe<MutableList<ShipAddress>?>(mView) {
            override fun onNext(t: MutableList<ShipAddress>?) {
                mView.onGetShipAddressResult(t)
            }
        }, lifecycleProvider)

    }

    /*
        设置默认收货人信息
     */
    fun setDefaultShipAddress(address: ShipAddress) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        shipAddressService.editShipAddress(address).execute(object : BaseSubscribe<Boolean>(mView) {
            override fun onNext(t: Boolean) {
                mView.onSetDefaultResult(t)
            }
        }, lifecycleProvider)

    }

    /*
        删除收货人信息
     */
    fun deleteShipAddress(id:Int) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        shipAddressService.deleteShipAddress(id).execute(object : BaseSubscribe<Boolean>(mView) {
            override fun onNext(t: Boolean) {
                mView.onDeleteResult(t)
            }
        }, lifecycleProvider)

    }

}
