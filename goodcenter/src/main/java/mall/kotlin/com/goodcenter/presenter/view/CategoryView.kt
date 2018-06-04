package mall.kotlin.com.goodcenter.presenter.view

import com.kotlin.goods.data.protocol.Category
import mall.kotlin.com.baselibrary.presenter.view.BaseView

/**
 * @author Dsh  on 2018/4/10.
 */

interface CategoryView : BaseView {

    fun onGetCategoryResult(result: MutableList<Category>?)

}