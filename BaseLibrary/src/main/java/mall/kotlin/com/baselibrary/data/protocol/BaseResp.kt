package mall.kotlin.com.baselibrary.data.protocol

/**
 * @author Dsh  on 2018/4/13.
 */
class BaseResp<out T>(val status:Int, val message:String, val data:T)