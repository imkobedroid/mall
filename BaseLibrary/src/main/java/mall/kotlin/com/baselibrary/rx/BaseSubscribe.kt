package mall.kotlin.com.baselibrary.rx

import io.reactivex.subscribers.ResourceSubscriber
import mall.kotlin.com.baselibrary.presenter.view.BaseView

/**
 * @author Dsh  on 2018/4/12.
 */
open class BaseSubscribe<T> (val baseView:BaseView?): ResourceSubscriber<T>() {
    override fun onError(t: Throwable?) {
        baseView?.hideLoading()
    }


    override fun onComplete() {
        baseView?.hideLoading()
    }

    override fun onNext(t: T) {
    }
}