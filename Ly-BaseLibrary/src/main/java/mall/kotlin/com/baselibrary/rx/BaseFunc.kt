package mall.kotlin.com.baselibrary.rx

import io.reactivex.Flowable
import io.reactivex.functions.Function
import mall.kotlin.com.baselibrary.common.ResultCode
import mall.kotlin.com.baselibrary.data.protocol.BaseResp

/**
 * @author Dsh  imkobedroid@gmail.com
 * @date 2020/5/12
 */
class BaseFunc<T> : Function<BaseResp<T>, Flowable<T>> {
    override fun apply(t: BaseResp<T>): Flowable<T> {
        return when {
            t.status != ResultCode.SUCCEED -> Flowable.error(BaseException(t.status, t.message))
            else -> Flowable.just(t.data)
        }
    }
}