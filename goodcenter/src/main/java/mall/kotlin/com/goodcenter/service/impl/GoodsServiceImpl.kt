package mall.kotlin.com.goodcenter.service.impl

import com.kotlin.goods.data.protocol.Goods
import io.reactivex.Flowable
import mall.kotlin.com.baselibrary.ext.convert
import mall.kotlin.com.goodcenter.date.repository.GoodsRepository
import mall.kotlin.com.goodcenter.service.GoodsService
import javax.inject.Inject

/**
 * @author Dsh  on 2018/4/12.
 */
class GoodsServiceImpl @Inject constructor() : GoodsService {

    @Inject lateinit var goodsRepository: GoodsRepository

    override fun getGoods(categoryId: Int, pageNo: Int): Flowable<MutableList<Goods>?> {
        return goodsRepository.getGoodsList(categoryId, pageNo).convert()
    }
}