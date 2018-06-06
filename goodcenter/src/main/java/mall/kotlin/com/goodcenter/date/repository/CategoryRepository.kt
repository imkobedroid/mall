package mall.kotlin.com.goodcenter.date.repository

import com.kotlin.goods.data.protocol.Category
import com.kotlin.goods.data.protocol.GetCategoryReq
import com.kotlin.goods.data.protocol.GetGoodsDetailReq
import com.kotlin.goods.data.protocol.Goods
import io.reactivex.Flowable
import mall.kotlin.com.baselibrary.data.net.RetrofitFactory
import mall.kotlin.com.baselibrary.data.protocol.BaseResp
import mall.kotlin.com.goodcenter.date.api.CategoryApi
import javax.inject.Inject

/**
 * @author Dsh  on 2018/4/13.
 */
class CategoryRepository @Inject constructor() {

    fun getCategory(parentId: Int): Flowable<BaseResp<MutableList<Category>?>> {
        return RetrofitFactory.instance.createApi(CategoryApi::class.java).getCategory(GetCategoryReq(parentId))
    }


    fun getGoodsDetail(goodId:Int):Flowable<BaseResp<Goods>>{
        return RetrofitFactory.instance.createApi(CategoryApi::class.java).getGoodsDetail(GetGoodsDetailReq(goodId))
    }


}