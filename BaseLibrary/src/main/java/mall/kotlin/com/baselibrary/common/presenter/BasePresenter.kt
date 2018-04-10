package mall.kotlin.com.baselibrary.common.presenter

import mall.kotlin.com.baselibrary.common.presenter.view.BaseView

/**
 * @author Dsh  on 2018/4/10.
 */
open class BasePresenter<T:BaseView> {

    lateinit var mView:T
}