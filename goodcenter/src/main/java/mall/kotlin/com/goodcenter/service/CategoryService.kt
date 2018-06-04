package mall.kotlin.com.goodcenter.service

import com.kotlin.goods.data.protocol.Category
import io.reactivex.Flowable

/**
 * @author Dsh  on 2018/4/12.
 */
interface CategoryService {
    fun getCategory(parentId: Int): Flowable<MutableList<Category>?>
}