package mall.kotlin.com.goodcenter.date.repository

import com.kotlin.goods.data.protocol.AddCartReq
import com.kotlin.goods.data.protocol.DeleteCartReq
import com.kotlin.goods.data.protocol.SubmitCartReq
import io.reactivex.Flowable
import mall.kotlin.com.baselibrary.data.net.RetrofitFactory
import mall.kotlin.com.baselibrary.data.protocol.BaseResp
import mall.kotlin.com.goodcenter.date.api.CartApi
import mall.kotlin.com.goodcenter.date.protocol.CartGoods
import javax.inject.Inject

/**
 * @author Dsh  on 2018/6/4.
 */
/*
    商品数据层
 */
class CartRepository @Inject constructor() {

    /*
       获取购物车列表
    */
    fun getCartList(): Flowable<BaseResp<MutableList<CartGoods>?>> {
        return RetrofitFactory.instance.createApi(CartApi::class.java).getCartList()
    }

    /*
        添加商品到购物车
     */
    fun addCart(goodsId: Int, goodsDesc: String, goodsIcon: String, goodsPrice: Long,
                goodsCount: Int, goodsSku: String): Flowable<BaseResp<Int>> {
        return RetrofitFactory.instance.createApi(CartApi::class.java)
                .addCart(AddCartReq(goodsId, goodsDesc, goodsIcon, goodsPrice, goodsCount, goodsSku))
    }

    /*
        删除购物车商品
     */
    fun deleteCartList(list: List<Int>): Flowable<BaseResp<String>> {
        return RetrofitFactory.instance.createApi(CartApi::class.java).deleteCartList(DeleteCartReq(list))
    }

    /*
        购物车结算
     */
    fun submitCart(list: MutableList<CartGoods>, totalPrice: Long): Flowable<BaseResp<Int>> {
        return RetrofitFactory.instance.createApi(CartApi::class.java).submitCart(SubmitCartReq(list, totalPrice))
    }

}