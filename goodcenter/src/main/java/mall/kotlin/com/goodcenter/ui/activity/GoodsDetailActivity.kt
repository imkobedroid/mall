package mall.kotlin.com.goodcenter.ui.activity

import android.os.Bundle
import android.support.design.widget.TabLayout
import com.eightbitlab.rxbus.Bus
import com.kotlin.provider.common.afterLogin
import kotlinx.android.synthetic.main.activity_goods_detail.*
import mall.kotlin.com.baselibrary.ui.activity.BaseActivity
import mall.kotlin.com.goodcenter.R
import mall.kotlin.com.goodcenter.event.AddCartEvent
import mall.kotlin.com.goodcenter.ui.adapter.GoodsDetailAdapter

/**
 * @author Dsh  on 2018/6/5.
 */
class GoodsDetailActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_goods_detail)
        initView()
    }

    private fun initView() {
        mGoodsDetailTab.tabMode = TabLayout.MODE_FIXED
        mGoodsDetailTab.setupWithViewPager(mGoodsDetailVp)
        mGoodsDetailVp.adapter = GoodsDetailAdapter(supportFragmentManager, this)


        mAddCartBtn.setOnClickListener {
            afterLogin {
                Bus.send(AddCartEvent())
            }
        }
    }
}