package mall.kotlin.com.goodcenter.service

import io.reactivex.Flowable

/**
 * @author Dsh  on 2018/4/12.
 */
interface CartService {

    fun addCart(goodsId: Int, goodsDesc: String, goodsIcon: String, goodsPrice: Long,
                goodsCount: Int, goodsSku: String): Flowable<Int>
}