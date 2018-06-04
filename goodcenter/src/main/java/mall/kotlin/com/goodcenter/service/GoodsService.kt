package mall.kotlin.com.goodcenter.service

import com.kotlin.goods.data.protocol.Goods
import io.reactivex.Flowable

/**
 * @author Dsh  on 2018/4/12.
 */
interface GoodsService {
    fun getGoods(categoryId: Int, pageNo: Int): Flowable<MutableList<Goods>?>
}