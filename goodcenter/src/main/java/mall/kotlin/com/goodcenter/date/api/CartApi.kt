package mall.kotlin.com.goodcenter.date.api

import com.kotlin.goods.data.protocol.AddCartReq
import mall.kotlin.com.goodcenter.date.protocol.CartGoods
import com.kotlin.goods.data.protocol.DeleteCartReq
import com.kotlin.goods.data.protocol.SubmitCartReq
import io.reactivex.Flowable
import mall.kotlin.com.baselibrary.data.protocol.BaseResp
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * @author Dsh  on 2018/6/6.
 */
interface CartApi {

    /*
      获取购物车列表
   */
    @POST("cart/getList")
    fun getCartList(): Flowable<BaseResp<MutableList<CartGoods>?>>

    /*
        添加商品到购物车
     */
    @POST("cart/add")
    fun addCart(@Body req: AddCartReq): Flowable<BaseResp<Int>>

    /*
        删除购物车商品
     */
    @POST("cart/delete")
    fun deleteCartList(@Body req: DeleteCartReq): Flowable<BaseResp<String>>

    /*
        提交购物车商品
     */
    @POST("cart/submit")
    fun submitCart(@Body req: SubmitCartReq): Flowable<BaseResp<Int>>

}