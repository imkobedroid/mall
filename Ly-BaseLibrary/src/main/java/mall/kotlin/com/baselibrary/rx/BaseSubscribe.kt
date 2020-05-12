package mall.kotlin.com.baselibrary.rx

import io.reactivex.subscribers.ResourceSubscriber
import mall.kotlin.com.baselibrary.presenter.view.BaseView

/**
 * @author Dsh  imkobedroid@gmail.com
 * @date 2020/5/12
 */
open class BaseSubscribe<T> (private val baseView:BaseView?): ResourceSubscriber<T>() {
    override fun onError(t: Throwable?) {
        baseView?.hideLoading()

        if (t is BaseException){
            baseView?.showError(t.msg)
        }
    }


    override fun onComplete() {
        baseView?.hideLoading()
    }

    override fun onNext(t: T) {
    }
}