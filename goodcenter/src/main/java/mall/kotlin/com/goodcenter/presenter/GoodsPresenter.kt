package mall.kotlin.com.goodcenter.presenter

import com.kotlin.goods.data.protocol.Goods
import mall.kotlin.com.baselibrary.ext.execute
import mall.kotlin.com.baselibrary.presenter.BasePresenter
import mall.kotlin.com.baselibrary.rx.BaseSubscribe
import mall.kotlin.com.baselibrary.utils.AppPrefsUtils
import mall.kotlin.com.goodcenter.common.GoodConstant
import mall.kotlin.com.goodcenter.presenter.view.GoodsView
import mall.kotlin.com.goodcenter.service.CartService
import mall.kotlin.com.goodcenter.service.CategoryService
import mall.kotlin.com.goodcenter.service.GoodsService
import javax.inject.Inject

/**
 * @author Dsh  on 2018/4/10.
 */
open class GoodsPresenter @Inject constructor() : BasePresenter<GoodsView>() {

    @Inject
    lateinit var goodsService: GoodsService


    @Inject
    lateinit var cartService: CartService


    @Inject
    lateinit var categoryService: CategoryService

    fun getGoods(categoryId: Int, pageNo: Int) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        goodsService.getGoods(categoryId, pageNo).execute(object : BaseSubscribe<MutableList<Goods>?>(mView) {
            override fun onNext(t: MutableList<Goods>?) {
                mView.onGetGoodsResult(t)
            }
        }, lifecycleProvider)
    }


    fun getGoodsDetails(goodId: Int) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        categoryService.getGoodsDetail(goodId).execute(object : BaseSubscribe<Goods>(mView) {
            override fun onNext(t: Goods) {
                mView.getGoodsDetail(t)
            }
        }, lifecycleProvider)
    }


    fun addCart(goodsId: Int, goodsDesc: String, goodsIcon: String, goodsPrice: Long,
                goodsCount: Int, goodsSku: String) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        cartService.addCart(goodsId, goodsDesc, goodsIcon, goodsPrice, goodsCount, goodsSku).execute(object : BaseSubscribe<Int>(mView) {
            override fun onNext(t: Int) {

                AppPrefsUtils.putInt(GoodConstant.SP_CART_SIZE,t)
                mView.addCart(t)
            }
        }, lifecycleProvider)
    }


}