package mall.kotlin.com.baselibrary.presenter

import android.content.Context
import com.trello.rxlifecycle2.LifecycleProvider
import mall.kotlin.com.baselibrary.presenter.view.BaseView
import mall.kotlin.com.baselibrary.utils.NetWorkUtils
import javax.inject.Inject

/**
 * @author Dsh  on 2018/4/10.
 */
open class BasePresenter<T : BaseView> {

    lateinit var mView: T

    @Inject
    lateinit var lifecycleProvider: LifecycleProvider<*>

    @Inject
    lateinit var context: Context

    fun checkNetWork(): Boolean {
        if (NetWorkUtils.isNetWorkAvailable(context)) {
            return true
        } else {
            mView.showError("网络不可用")
        }
        return false
    }
}