package mall.kotlin.com.baselibrary.common.ui.activity

import mall.kotlin.com.baselibrary.common.presenter.BasePresenter
import mall.kotlin.com.baselibrary.common.presenter.view.BaseView

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