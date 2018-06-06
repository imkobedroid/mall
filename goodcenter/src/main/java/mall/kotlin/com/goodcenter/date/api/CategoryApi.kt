package mall.kotlin.com.goodcenter.date.api

import com.kotlin.goods.data.protocol.*
import io.reactivex.Flowable
import mall.kotlin.com.baselibrary.data.protocol.BaseResp
import retrofit2.http.Body
import retrofit2.http.POST
import rx.Observable

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


    /*
      获取商品列表
   */
    @POST("goods/getGoodsList")
    fun getGoodsList(@Body req: GetGoodsListReq): Flowable<BaseResp<MutableList<Goods>?>>

    /*
        获取商品列表
     */
    @POST("goods/getGoodsListByKeyword")
    fun getGoodsListByKeyword(@Body req: GetGoodsListByKeywordReq): Flowable<BaseResp<MutableList<Goods>?>>

    /*
        获取商品详情
     */
    @POST("goods/getGoodsDetail")
    fun getGoodsDetail(@Body req: GetGoodsDetailReq): Flowable<BaseResp<Goods>>
}