package mall.kotlin.com.baselibrary.presenter

import android.content.Context
import com.trello.rxlifecycle3.LifecycleProvider
import mall.kotlin.com.baselibrary.presenter.view.BaseView
import mall.kotlin.com.baselibrary.utils.NetWorkUtils
import javax.inject.Inject

/**
 * @author Dsh  imkobedroid@gmail.com
 * @date 2020/5/12
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