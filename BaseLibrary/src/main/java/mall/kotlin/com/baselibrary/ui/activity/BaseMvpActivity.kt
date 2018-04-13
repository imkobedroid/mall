package mall.kotlin.com.baselibrary.ui.activity

import mall.kotlin.com.baselibrary.presenter.BasePresenter
import mall.kotlin.com.baselibrary.presenter.view.BaseView

/**
 * @author Dsh  on 2018/4/10.
 */
open class BaseMvpActivity <T:BasePresenter<*>>:BaseActivity(),BaseView {

    lateinit var mPresenter:T


    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun showError() {
    }
}