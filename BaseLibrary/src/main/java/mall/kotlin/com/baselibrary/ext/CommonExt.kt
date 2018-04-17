package mall.kotlin.com.baselibrary.ext

import com.trello.rxlifecycle2.LifecycleProvider
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import mall.kotlin.com.baselibrary.rx.BaseSubscribe

/**
 * @author Dsh  on 2018/4/12.
 */
fun <T> Flowable<T>.execute(subscribe: BaseSubscribe<T>,lifecycleProvider: LifecycleProvider<*>) {
     this.subscribeOn(Schedulers.io())
             .compose(lifecycleProvider.bindToLifecycle())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(subscribe)
}