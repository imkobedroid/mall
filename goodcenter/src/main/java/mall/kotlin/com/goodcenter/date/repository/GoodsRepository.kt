package mall.kotlin.com.goodcenter.date.repository

import com.kotlin.goods.data.protocol.GetGoodsDetailReq
import com.kotlin.goods.data.protocol.GetGoodsListByKeywordReq
import com.kotlin.goods.data.protocol.GetGoodsListReq
import com.kotlin.goods.data.protocol.Goods
import io.reactivex.Flowable
import mall.kotlin.com.baselibrary.data.net.RetrofitFactory
import mall.kotlin.com.baselibrary.data.protocol.BaseResp
import mall.kotlin.com.goodcenter.date.api.GoodsApi
import javax.inject.Inject

/**
 * @author Dsh  on 2018/6/4.
 */
/*
    商品数据层
 */
class GoodsRepository @Inject constructor() {

    /*
        根据分类搜索商品
     */
    fun getGoodsList(categoryId: Int, pageNo: Int): Flowable<BaseResp<MutableList<Goods>?>> {
        return RetrofitFactory.instance.createApi(GoodsApi::class.java).getGoodsList(GetGoodsListReq(categoryId, pageNo))
    }

    /*
        根据关键字搜索商品
     */
    fun getGoodsListByKeyword(keyword: String, pageNo: Int): Flowable<BaseResp<MutableList<Goods>?>> {
        return RetrofitFactory.instance.createApi(GoodsApi::class.java).getGoodsListByKeyword(GetGoodsListByKeywordReq(keyword, pageNo))
    }

    /*
        商品详情
     */
    fun getGoodsDetail(goodsId: Int): Flowable<BaseResp<Goods>> {
        return RetrofitFactory.instance.createApi(GoodsApi::class.java).getGoodsDetail(GetGoodsDetailReq(goodsId))
    }
}