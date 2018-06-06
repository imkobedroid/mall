package mall.kotlin.com.goodcenter.ui.adapter

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import mall.kotlin.com.goodcenter.ui.fragment.GoodsTabOneFragment
import mall.kotlin.com.goodcenter.ui.fragment.GoodsTabTwoFragment

/**
 * @author Dsh  on 2018/6/5.
 */
class GoodsDetailAdapter(fm: FragmentManager, context: Context) : FragmentPagerAdapter(fm) {


    private val title= arrayListOf("商品","详情")

    override fun getItem(position: Int): Fragment {
        return if (position == 0) GoodsTabOneFragment() else GoodsTabTwoFragment()
    }

    override fun getCount(): Int {
        return title.size
    }

    override fun getPageTitle(position: Int): CharSequence {
        return title[position]
    }
}