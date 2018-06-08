package mall.kotlin.com.goodcenter.service

import io.reactivex.Flowable
import mall.kotlin.com.goodcenter.date.protocol.CartGoods

/**
 * @author Dsh  on 2018/4/12.
 */
interface CartService {

    fun addCart(goodsId: Int, goodsDesc: String, goodsIcon: String, goodsPrice: Long,
                goodsCount: Int, goodsSku: String): Flowable<Int>

    /*
      获取购物车列表
   */
    fun getCartList(): Flowable<MutableList<CartGoods>?>

    /*
        删除购物车商品
     */
    fun deleteCartList(list: List<Int>): Flowable<Boolean>

    /*
        购物车结算
    */
    fun submitCart(list: MutableList<CartGoods>, totalPrice: Long): Flowable<Int>
}