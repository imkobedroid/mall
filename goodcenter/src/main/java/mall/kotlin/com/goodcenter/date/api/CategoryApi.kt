package mall.kotlin.com.goodcenter.date.api

import io.reactivex.Flowable
import mall.kotlin.com.baselibrary.data.protocol.BaseResp
import mall.kotlin.com.goodcenter.date.protocol.Category
import mall.kotlin.com.goodcenter.date.protocol.GetCategoryReq
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