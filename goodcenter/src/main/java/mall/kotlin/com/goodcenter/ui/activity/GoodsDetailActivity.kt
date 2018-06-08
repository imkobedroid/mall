package mall.kotlin.com.goodcenter.ui.activity

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.view.Gravity
import com.eightbitlab.rxbus.Bus
import com.eightbitlab.rxbus.registerInBus
import com.kotlin.provider.common.afterLogin
import kotlinx.android.synthetic.main.activity_goods_detail.*
import mall.kotlin.com.baselibrary.ui.activity.BaseActivity
import mall.kotlin.com.baselibrary.utils.AppPrefsUtils
import mall.kotlin.com.goodcenter.R
import mall.kotlin.com.goodcenter.common.GoodConstant
import mall.kotlin.com.goodcenter.event.AddCartEvent
import mall.kotlin.com.goodcenter.event.UpdateCartSizeEvent
import mall.kotlin.com.goodcenter.ui.adapter.GoodsDetailAdapter
import org.jetbrains.anko.startActivity
import q.rorbin.badgeview.QBadgeView

/**
 * @author Dsh  on 2018/6/5.
 */
class GoodsDetailActivity : BaseActivity() {


    private lateinit var mCartBdage: QBadgeView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_goods_detail)
        initView()
        loadCartSize()
        initObserver()
    }

    private fun loadCartSize() {
        setCartBadge()
    }

    private fun initObserver() {
        Bus.observe<UpdateCartSizeEvent>().subscribe {
            setCartBadge()
        }.registerInBus(this)
    }

    private fun setCartBadge() {
        mCartBdage.badgeGravity = Gravity.END or  Gravity.TOP
        mCartBdage.setGravityOffset(22f, -2f, true)
        mCartBdage.setBadgeTextSize(6f, true)
        mCartBdage.bindTarget(mEnterCartTv).badgeNumber = AppPrefsUtils.getInt(GoodConstant.SP_CART_SIZE)
    }

    private fun initView() {
        mCartBdage = QBadgeView(this)
        mGoodsDetailTab.tabMode = TabLayout.MODE_FIXED
        mGoodsDetailTab.setupWithViewPager(mGoodsDetailVp)
        mGoodsDetailVp.adapter = GoodsDetailAdapter(supportFragmentManager, this)


        mAddCartBtn.setOnClickListener {
            afterLogin {
                Bus.send(AddCartEvent())
            }
        }

        mEnterCartTv.setOnClickListener {
            startActivity<CartActivity>()
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        Bus.unregister(this)
    }
}