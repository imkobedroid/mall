package mall.kotlin.com.baselibrary.presenter

import mall.kotlin.com.baselibrary.presenter.view.BaseView

/**
 * @author Dsh  on 2018/4/10.
 */
open class BasePresenter<T:BaseView> {

    lateinit var mView:T
}