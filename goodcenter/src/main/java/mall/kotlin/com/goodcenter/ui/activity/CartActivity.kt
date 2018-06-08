package mall.kotlin.com.goodcenter.ui.activity

import android.os.Bundle
import mall.kotlin.com.baselibrary.ui.activity.BaseActivity
import mall.kotlin.com.goodcenter.R
import mall.kotlin.com.goodcenter.ui.fragment.CartFragment

/**
 * @author Dsh  on 2018/6/8.
 */
class CartActivity: BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        val fragment = supportFragmentManager.findFragmentById(R.id.fragment_cart)
        (fragment as CartFragment).setBackVisible(true)

    }
}
