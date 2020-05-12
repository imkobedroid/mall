package mall.kotlin.com.baselibrary.data.protocol

/**
 * @author Dsh  imkobedroid@gmail.com
 * @date 2020/5/12
 */
class BaseResp<out T>(val status:Int, val message:String, val data:T)