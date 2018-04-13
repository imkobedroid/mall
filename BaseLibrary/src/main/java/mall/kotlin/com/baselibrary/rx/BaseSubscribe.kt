package mall.kotlin.com.baselibrary.rx

import io.reactivex.subscribers.ResourceSubscriber

/**
 * @author Dsh  on 2018/4/12.
 */
open class BaseSubscribe<T> : ResourceSubscriber<T>() {
    override fun onError(t: Throwable?) {
    }

    override fun onComplete() {
    }

    override fun onNext(t: T) {
    }
}