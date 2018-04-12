package mall.kotlin.com.baselibrary.common.ext

import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import mall.kotlin.com.baselibrary.common.rx.BaseSubscribe

/**
 * @author Dsh  on 2018/4/12.
 */
fun <T> Flowable<T>.execute(subscribe: BaseSubscribe<T>) {
     this.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(subscribe)
}