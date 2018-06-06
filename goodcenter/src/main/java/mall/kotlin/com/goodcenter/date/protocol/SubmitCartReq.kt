package com.kotlin.goods.data.protocol

import mall.kotlin.com.goodcenter.date.protocol.CartGoods

/*
    提交购物车
 */
data class SubmitCartReq(val goodsList: List<CartGoods>, val totalPrice: Long)
