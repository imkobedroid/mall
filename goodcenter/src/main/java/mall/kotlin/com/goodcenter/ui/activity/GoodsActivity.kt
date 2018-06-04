package mall.kotlin.com.goodcenter.ui.activity

import com.kotlin.goods.data.protocol.Goods
import mall.kotlin.com.baselibrary.ui.activity.BaseMvpActivity
import mall.kotlin.com.goodcenter.injection.component.DaggerCategoryComponent
import mall.kotlin.com.goodcenter.injection.module.CategoryModule
import mall.kotlin.com.goodcenter.presenter.GoodsPresenter
import mall.kotlin.com.goodcenter.presenter.view.GoodsView

/**
 * @author Dsh  on 2018/6/4.
 */
class GoodsActivity : BaseMvpActivity<GoodsPresenter>(), GoodsView {
    override fun onGetGoodsResult(result: MutableList<Goods>?) {

    }


    override fun injectComponent() {
        DaggerCategoryComponent.builder().activityComponent(activityComponent).categoryModule(CategoryModule()).build()
                .inject(this)
        mPresenter.mView = this
    }
}