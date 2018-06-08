package mall.kotlin.com.goodcenter.service.impl

import io.reactivex.Flowable
import mall.kotlin.com.baselibrary.ext.convert
import mall.kotlin.com.baselibrary.ext.convertBoolean
import mall.kotlin.com.goodcenter.date.protocol.CartGoods
import mall.kotlin.com.goodcenter.date.repository.CartRepository
import mall.kotlin.com.goodcenter.service.CartService
import rx.Observable
import javax.inject.Inject

/**
 * @author Dsh  on 2018/4/12.
 */
class CartServiceImpl @Inject constructor() : CartService {

    @Inject lateinit var cartRepository: CartRepository

    override fun addCart(goodsId: Int, goodsDesc: String, goodsIcon: String, goodsPrice: Long,
                         goodsCount: Int, goodsSku: String): Flowable<Int> {
        return cartRepository.addCart(goodsId, goodsDesc,goodsIcon,goodsPrice,goodsCount,goodsSku).convert()
    }


    /*
       获取购物车列表
    */
    override fun getCartList(): Flowable<MutableList<CartGoods>?> {
        return cartRepository.getCartList().convert()
    }

    /*
        删除购物车商品
     */
    override fun deleteCartList(list: List<Int>): Flowable<Boolean> {
        return cartRepository.deleteCartList(list).convertBoolean()
    }

    /*
        提交购物车商品
     */
    override fun submitCart(list: MutableList<CartGoods>, totalPrice: Long): Flowable<Int> {
        return cartRepository.submitCart(list,totalPrice).convert()
    }
}


