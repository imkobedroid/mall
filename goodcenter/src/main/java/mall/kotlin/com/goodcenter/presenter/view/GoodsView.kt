package mall.kotlin.com.goodcenter.presenter.view

import com.kotlin.goods.data.protocol.Goods
import mall.kotlin.com.baselibrary.presenter.view.BaseView

/**
 * @author Dsh  on 2018/4/10.
 */

interface GoodsView : BaseView {

    fun onGetGoodsResult(result: MutableList<Goods>?)

    fun getGoodsDetail(goods: Goods)

}