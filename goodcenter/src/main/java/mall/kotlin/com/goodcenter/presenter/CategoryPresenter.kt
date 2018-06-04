package mall.kotlin.com.goodcenter.presenter

import com.kotlin.goods.data.protocol.Category
import mall.kotlin.com.baselibrary.ext.execute
import mall.kotlin.com.baselibrary.presenter.BasePresenter
import mall.kotlin.com.baselibrary.rx.BaseSubscribe
import mall.kotlin.com.goodcenter.presenter.view.CategoryView
import mall.kotlin.com.goodcenter.service.CategoryService
import javax.inject.Inject

/**
 * @author Dsh  on 2018/4/10.
 */
open class CategoryPresenter @Inject constructor() : BasePresenter<CategoryView>() {

    @Inject
    lateinit var categoryService: CategoryService

    fun getCategory(parentId: Int) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        categoryService.getCategory(parentId).execute(object : BaseSubscribe<MutableList<Category>?>(mView) {
            override fun onNext(t: MutableList<Category>?) {
                mView.onGetCategoryResult(t)
            }
        }, lifecycleProvider)
    }
}