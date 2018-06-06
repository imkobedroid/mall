package mall.kotlin.com.goodcenter.service.impl

import io.reactivex.Flowable
import mall.kotlin.com.baselibrary.ext.convert
import mall.kotlin.com.goodcenter.date.repository.CartRepository
import mall.kotlin.com.goodcenter.service.CartService
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
}


