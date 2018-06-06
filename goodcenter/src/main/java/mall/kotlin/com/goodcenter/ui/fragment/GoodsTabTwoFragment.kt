package mall.kotlin.com.goodcenter.ui.fragment

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.eightbitlab.rxbus.Bus
import com.eightbitlab.rxbus.registerInBus
import com.kennyc.view.MultiStateView
import com.kotlin.goods.data.protocol.Category
import kotlinx.android.synthetic.main.fragment_goods_detail_tab_two.*
import mall.kotlin.com.baselibrary.ext.loadUrl
import mall.kotlin.com.baselibrary.ui.adapter.BaseRecyclerViewAdapter
import mall.kotlin.com.baselibrary.ui.fragment.BaseFragment
import mall.kotlin.com.baselibrary.ui.fragment.BaseMvpFragment
import mall.kotlin.com.goodcenter.R
import mall.kotlin.com.goodcenter.common.GoodConstant
import mall.kotlin.com.goodcenter.event.GoodsDetailImageEvent
import mall.kotlin.com.goodcenter.injection.component.DaggerCategoryComponent
import mall.kotlin.com.goodcenter.injection.module.CategoryModule
import mall.kotlin.com.goodcenter.presenter.CategoryPresenter
import mall.kotlin.com.goodcenter.presenter.view.CategoryView
import mall.kotlin.com.goodcenter.ui.activity.GoodsActivity
import mall.kotlin.com.goodcenter.ui.adapter.SecondCategoryAdapter
import mall.kotlin.com.goodcenter.ui.adapter.TopCategoryAdapter

/**
 * @author Dsh  on 2018/6/4.
 */
class GoodsTabTwoFragment : BaseFragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater?.inflate(R.layout.fragment_goods_detail_tab_two, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObserver()
    }

    private fun initObserver() {
        Bus.observe<GoodsDetailImageEvent>()
                .subscribe {
                    kotlin.run {
                        mGoodsDetailOneIv.loadUrl(it.imageOne)
                        mGoodsDetailTwoIv.loadUrl(it.imageTwo)
                    }
                }.registerInBus(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        Bus.unregister(this)
    }

}