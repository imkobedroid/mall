package mall.kotlin.com.baselibrary.rx

import io.reactivex.Flowable
import io.reactivex.functions.Function
import mall.kotlin.com.baselibrary.common.ResultCode
import mall.kotlin.com.baselibrary.data.protocol.BaseResp


/**
 * @author Dsh  imkobedroid@gmail.com
 * @date 2020/5/12
 */
class BaseFuncBoolean<T> :Function<BaseResp<T>,Flowable<Boolean>> {
    override fun apply(t: BaseResp<T>): Flowable<Boolean> {
        if (t.status != ResultCode.SUCCEED) {
            return Flowable.error(BaseException(t.status, t.message))
        }
            return Flowable.just(true)
    }
}