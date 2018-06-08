package com.kotlin.provider.router

/**
 * @author Dsh  on 2018/6/6.
 */
object RouterPath {
      class UserCenter{
          companion object {
              const val PATH_LOGIN = "/userCenter/login"
          }
      }



    //订单模块
    class OrderCenter{
        companion object {
            const val PATH_ORDER_CONFIRM = "/orderCenter/confirm"
        }
    }


    //支付模块
    class PaySDK{
        companion object {
            const val PATH_PAY = "/paySDK/pay"
        }
    }

    //消息模块
    class MessageCenter{
        companion object {
            const val PATH_MESSAGE_PUSH = "/messageCenter/push"
            const val PATH_MESSAGE_ORDER = "/messageCenter/order"
        }
    }
}