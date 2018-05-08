package mall.kotlin.com.baselibrary.ui.activity

import android.os.Bundle
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity
import mall.kotlin.com.baselibrary.common.AppManager

/**
 * @author Dsh  on 2018/4/10.
 */
open class BaseActivity :RxAppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppManager.instance.addActivity(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        AppManager.instance.finishActivity(this)
    }
}