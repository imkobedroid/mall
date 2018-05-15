package mall.kotlin.com.baselibrary.rx

import io.reactivex.Flowable
import io.reactivex.functions.Function
import mall.kotlin.com.baselibrary.common.ResultCode
import mall.kotlin.com.baselibrary.data.protocol.BaseResp

/**
 * @author Dsh  on 2018/4/18.
 */
class BaseFunc<T> : Function<BaseResp<T>, Flowable<T>> {
    override fun apply(t: BaseResp<T>): Flowable<T> {
        if (t.status != ResultCode.SUCCEED) {
            return Flowable.error(BaseException(t.status, t.message))
        }
            return Flowable.just(t.data)
    }
}