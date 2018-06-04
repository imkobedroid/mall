package mall.kotlin.com.goodcenter.ui.activity

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import com.kennyc.view.MultiStateView
import com.kotlin.goods.data.protocol.Goods
import kotlinx.android.synthetic.main.activity_goods.*
import mall.kotlin.com.baselibrary.ext.startLoading
import mall.kotlin.com.baselibrary.ui.activity.BaseMvpActivity
import mall.kotlin.com.goodcenter.R
import mall.kotlin.com.goodcenter.common.GoodConstant
import mall.kotlin.com.goodcenter.injection.component.DaggerCategoryComponent
import mall.kotlin.com.goodcenter.injection.module.CategoryModule
import mall.kotlin.com.goodcenter.presenter.GoodsPresenter
import mall.kotlin.com.goodcenter.presenter.view.GoodsView
import mall.kotlin.com.goodcenter.ui.adapter.GoodsAdapter

/**
 * @author Dsh  on 2018/6/4.
 */
class GoodsActivity : BaseMvpActivity<GoodsPresenter>(), GoodsView {


    private var mMaxPage: Int = 1
    private var mCurrentPage: Int = 1

    private lateinit var mGoodsAdapter: GoodsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_goods)
        initView()
    }

    private fun initView() {
        mGoodsRv.layoutManager = GridLayoutManager(this, 2)
        mGoodsAdapter = GoodsAdapter(this)
        mGoodsRv.adapter = mGoodsAdapter
        loadData()
    }

    private fun loadData() {
        mMultiStateView.startLoading()
        mPresenter.getGoods(intent.getIntExtra(GoodConstant.KEY_CATEGORY_ID, 1), 1)
    }

    override fun onGetGoodsResult(result: MutableList<Goods>?) {
        if (result != null && result.size > 0) {
            mMaxPage = result[0].maxPage
            if (mCurrentPage == 1) {
                mGoodsAdapter.setData(result)
            } else {
                mGoodsAdapter.dataList.addAll(result)
                mGoodsAdapter.notifyDataSetChanged()
            }
            mMultiStateView.viewState = MultiStateView.VIEW_STATE_CONTENT
        } else {
            mMultiStateView.viewState = MultiStateView.VIEW_STATE_EMPTY
        }
    }


    override fun injectComponent() {
        DaggerCategoryComponent.builder().activityComponent(activityComponent).categoryModule(CategoryModule()).build()
                .inject(this)
        mPresenter.mView = this
    }
}