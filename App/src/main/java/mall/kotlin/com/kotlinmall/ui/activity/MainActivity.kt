package mall.kotlin.com.kotlinmall.ui.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.eightbitlab.rxbus.Bus
import com.eightbitlab.rxbus.registerInBus
import kotlinx.android.synthetic.main.activity_main.*
import mall.kotlin.com.baselibrary.utils.AppPrefsUtils
import mall.kotlin.com.goodcenter.common.GoodConstant
import mall.kotlin.com.goodcenter.event.UpdateCartSizeEvent
import mall.kotlin.com.goodcenter.ui.fragment.CartFragment
import mall.kotlin.com.goodcenter.ui.fragment.CategoryFragment
import mall.kotlin.com.kotlinmall.R
import mall.kotlin.com.kotlinmall.ui.fragment.HomeFragment
import mall.kotlin.com.kotlinmall.ui.fragment.MeFragment
import java.util.*

class MainActivity : AppCompatActivity() {

    private val mStack = Stack<Fragment>()
    private val mHomeFragment by lazy { HomeFragment() }
    private val mCategoryFragment by lazy { CategoryFragment() }
    private val mCartFragment by lazy { CartFragment() }
    private val mMsgFragment by lazy { MeFragment() }
    private val mMeFragment by lazy { MeFragment() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottom_navigation_bar.checkCartBadge(10)
        bottom_navigation_bar.checkMsgBadge(false)
        initStack()
        initView()
        initObserver()
        initNav(0)
    }



    private fun initStack() {
        initManage()
        mStack.add(mHomeFragment)
        mStack.add(mCategoryFragment)
        mStack.add(mCartFragment)
        mStack.add(mMsgFragment)
        mStack.add(mMeFragment)
    }

    @SuppressLint("CommitTransaction")
    private fun initManage() {
        val manage = supportFragmentManager.beginTransaction()
        manage.add(R.id.frame_layout,mHomeFragment)
        manage.add(R.id.frame_layout,mCategoryFragment)
        manage.add(R.id.frame_layout,mCartFragment)
        manage.add(R.id.frame_layout,mMsgFragment)
        manage.add(R.id.frame_layout,mMeFragment)
        manage.commit()
    }

    @SuppressLint("CommitTransaction")
    private fun initView() {
        bottom_navigation_bar.checkCartBadge(AppPrefsUtils.getInt(GoodConstant.SP_CART_SIZE))
        bottom_navigation_bar.setTabSelectedListener(object : BottomNavigationBar.OnTabSelectedListener {
            override fun onTabReselected(position: Int) {
            }

            override fun onTabUnselected(position: Int) {
            }

            override fun onTabSelected(position: Int) {
                initNav(position)
            }

        })
    }

    @SuppressLint("CommitTransaction")
    private fun initNav(position: Int) {
        val manage = supportFragmentManager.beginTransaction()
        for (fragment in mStack){
            manage.hide(fragment)
        }
        manage.show(mStack[position])
        manage.commit()
    }

    private fun initObserver() {
        Bus.observe<UpdateCartSizeEvent>().subscribe {
            bottom_navigation_bar.checkCartBadge(AppPrefsUtils.getInt(GoodConstant.SP_CART_SIZE))
        }.registerInBus(this)
    }


    override fun onDestroy() {
        super.onDestroy()
        Bus.unregister(this)
    }
}
