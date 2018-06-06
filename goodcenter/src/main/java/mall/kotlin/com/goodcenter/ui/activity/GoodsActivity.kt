package mall.kotlin.com.goodcenter.ui.activity

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import cn.bingoogolapple.refreshlayout.BGANormalRefreshViewHolder
import cn.bingoogolapple.refreshlayout.BGARefreshLayout
import com.kennyc.view.MultiStateView
import com.kotlin.goods.data.protocol.Goods
import kotlinx.android.synthetic.main.activity_goods.*
import mall.kotlin.com.baselibrary.ext.startLoading
import mall.kotlin.com.baselibrary.ui.activity.BaseMvpActivity
import mall.kotlin.com.baselibrary.ui.adapter.BaseRecyclerViewAdapter
import mall.kotlin.com.goodcenter.R
import mall.kotlin.com.goodcenter.common.GoodConstant
import mall.kotlin.com.goodcenter.injection.component.DaggerCategoryComponent
import mall.kotlin.com.goodcenter.injection.module.CategoryModule
import mall.kotlin.com.goodcenter.presenter.GoodsPresenter
import mall.kotlin.com.goodcenter.presenter.view.GoodsView
import mall.kotlin.com.goodcenter.ui.adapter.GoodsAdapter
import org.jetbrains.anko.startActivity

/**
 * @author Dsh  on 2018/6/4.
 */
class GoodsActivity : BaseMvpActivity<GoodsPresenter>(), GoodsView, BGARefreshLayout.BGARefreshLayoutDelegate {


    override fun getGoodsDetail(goods: Goods) {

    }

    override fun addCart(count:Int){

    }


    private var mMaxPage: Int = 1
    private var mCurrentPage: Int = 1

    private lateinit var mGoodsAdapter: GoodsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_goods)
        initRefreshLayout()
        initView()
    }

    private fun initRefreshLayout() {
        mRefreshLayout.setDelegate(this)
        val viewHolder = BGANormalRefreshViewHolder(this, true)
        viewHolder.setLoadMoreBackgroundColorRes(R.color.common_bg)
        viewHolder.setRefreshViewBackgroundColorRes(R.color.common_bg)
        mRefreshLayout.setRefreshViewHolder(viewHolder)
    }

    private fun initView() {
        mGoodsRv.layoutManager = GridLayoutManager(this, 2)
        mGoodsAdapter = GoodsAdapter(this)
        mGoodsRv.adapter = mGoodsAdapter
        mGoodsAdapter.setOnItemClickListener(object : BaseRecyclerViewAdapter.OnItemClickListener<Goods> {
            override fun onItemClick(item: Goods, position: Int) {
                startActivity<GoodsDetailActivity>(GoodConstant.KEY_GOODS_ID to item.id)
            }
        })
        loadData()
    }

    private fun loadData() {
        mMultiStateView.startLoading()
        mPresenter.getGoods(intent.getIntExtra(GoodConstant.KEY_CATEGORY_ID, 1), 1)
    }

    override fun onGetGoodsResult(result: MutableList<Goods>?) {

        mRefreshLayout.endLoadingMore()
        mRefreshLayout.endRefreshing()
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


    override fun onBGARefreshLayoutBeginLoadingMore(refreshLayout: BGARefreshLayout?): Boolean {
        return if (mCurrentPage < mMaxPage) {
            mCurrentPage++
            loadData()
            true
        } else {
            false
        }
    }

    override fun onBGARefreshLayoutBeginRefreshing(refreshLayout: BGARefreshLayout?) {
        mCurrentPage = 1
        loadData()
    }
}