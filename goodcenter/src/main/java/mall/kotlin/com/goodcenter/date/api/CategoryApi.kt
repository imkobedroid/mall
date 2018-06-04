package mall.kotlin.com.goodcenter.date.api

import com.kotlin.goods.data.protocol.Category
import com.kotlin.goods.data.protocol.GetCategoryReq
import io.reactivex.Flowable
import mall.kotlin.com.baselibrary.data.protocol.BaseResp
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * @author Dsh  on 2018/5/25.
 */
/*
    商品分类接口
 */
interface CategoryApi {
    /*
        获取商品分类列表
     */
    @POST("category/getCategory")
    fun getCategory(@Body req: GetCategoryReq): Flowable<BaseResp<MutableList<Category>?>>
}