package mall.kotlin.com.baselibrary.presenter

import com.trello.rxlifecycle2.LifecycleProvider
import mall.kotlin.com.baselibrary.presenter.view.BaseView
import javax.inject.Inject

/**
 * @author Dsh  on 2018/4/10.
 */
open class BasePresenter<T : BaseView> {

    lateinit var mView: T

    @Inject
    lateinit var lifecycleProvider: LifecycleProvider<*>
}