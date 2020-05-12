package mall.kotlin.com.baselibrary.common

import android.content.Context
import java.util.*

/**
 * @author Dsh  imkobedroid@gmail.com
 * @date 2020/5/12
 */
class ResultCode {
    companion object {
        const val SUCCEED = 0
        private const val UNIQUE_ID = "UNIQUE_ID"
        private var uniqueID: String? = null


        fun requestDeviceId(context: Context): String {
            if (uniqueID == null) {
                val sharedPrefs = context.getSharedPreferences(
                        UNIQUE_ID, Context.MODE_PRIVATE
                )
                uniqueID = sharedPrefs.getString(UNIQUE_ID, null)
                if (uniqueID == null) {
                    uniqueID = UUID.randomUUID().toString()
                    val editor = sharedPrefs.edit()
                    editor.putString(UNIQUE_ID, uniqueID)
                    editor.apply()
                }
            }
            return uniqueID as String
        }
    }
}