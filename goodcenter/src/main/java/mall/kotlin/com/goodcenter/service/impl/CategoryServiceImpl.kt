package mall.kotlin.com.goodcenter.service.impl

import com.kotlin.goods.data.protocol.Category
import com.kotlin.goods.data.protocol.Goods
import io.reactivex.Flowable
import mall.kotlin.com.baselibrary.ext.convert
import mall.kotlin.com.goodcenter.date.repository.CategoryRepository
import mall.kotlin.com.goodcenter.service.CategoryService
import javax.inject.Inject

/**
 * @author Dsh  on 2018/4/12.
 */
class CategoryServiceImpl @Inject constructor() : CategoryService {


    @Inject lateinit var categoryRepository: CategoryRepository

    override fun getCategory(parentId: Int): Flowable<MutableList<Category>?> {
        return categoryRepository.getCategory(parentId).convert()
    }

    override fun getGoodsDetail(goodId: Int): Flowable<Goods> {
        return categoryRepository.getGoodsDetail(goodId).convert()
    }
}