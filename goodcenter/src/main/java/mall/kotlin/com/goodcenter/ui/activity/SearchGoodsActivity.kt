package mall.kotlin.com.goodcenter.ui.activity

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import kotlinx.android.synthetic.main.activity_search_goods.*
import mall.kotlin.com.baselibrary.ext.onClick
import mall.kotlin.com.baselibrary.ext.setVisible
import mall.kotlin.com.baselibrary.ui.activity.BaseActivity
import mall.kotlin.com.baselibrary.ui.adapter.BaseRecyclerViewAdapter
import mall.kotlin.com.baselibrary.utils.AppPrefsUtils
import mall.kotlin.com.goodcenter.R
import mall.kotlin.com.goodcenter.R.*
import mall.kotlin.com.goodcenter.common.GoodConstant
import mall.kotlin.com.goodcenter.ui.adapter.SearchHistoryAdapter
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

/**
 * @author Dsh  on 2018/6/5.
 */
class SearchGoodsActivity : BaseActivity(), View.OnClickListener {
    private lateinit var mAdapter: SearchHistoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_goods)
        initView()
    }

    override fun onStart() {
        super.onStart()
        loadData()
    }

    /*
        初始化视图
     */
    private fun initView() {

        mLeftIv.onClick(this)
        mSearchTv.onClick(this)
        mClearBtn.onClick(this)
        //RecyclerView适配器
        mAdapter = SearchHistoryAdapter(this)
        mSearchHistoryRv.layoutManager = LinearLayoutManager(this)
        mSearchHistoryRv.adapter = mAdapter
        //item点击事件
        mAdapter.mItemClickListener = object : BaseRecyclerViewAdapter.OnItemClickListener<String> {
            override fun onItemClick(item: String, position: Int) {
                enterGoodsList(item)
            }
        }
    }

    /*
        从SP中加载数据
     */
    private fun loadData() {
        val set = AppPrefsUtils.getStringSet(GoodConstant.SP_SEARCH_HISTORY)
        mNoDataTv.setVisible(set.isEmpty())
        mDataView.setVisible(set.isNotEmpty())
        if (set.isNotEmpty()) {
            val list = mutableListOf<String>()
            list.addAll(set)
            mAdapter.setData(list)
        }
    }

    override fun onClick(v: View) {
        when (v.id) {
            id.mLeftIv -> finish()
        //执行搜索
            id.mSearchTv -> doSearch()
        //清除历史记录
            id.mClearBtn -> {
                AppPrefsUtils.remove(GoodConstant.SP_SEARCH_HISTORY)
                loadData()
            }
        }
    }

    //搜索
    private fun doSearch() {
        if (mKeywordEt.text.isNullOrEmpty()) {
            toast("请输入需要搜索的关键字")
        } else {
            val inputValue = mKeywordEt.text.toString()
            AppPrefsUtils.putStringSet(GoodConstant.SP_SEARCH_HISTORY, mutableSetOf(inputValue))
            enterGoodsList(inputValue)
        }
    }

    /*
        进入商品列表界面
     */
    private fun enterGoodsList(value: String) {
        //输入不为空，进入商品列表
        startActivity<GoodsActivity>(
                GoodConstant.KEY_SEARCH_GOODS_TYPE to GoodConstant.SEARCH_GOODS_TYPE_KEYWORD,
                GoodConstant.KEY_GOODS_KEYWORD to value
        )

    }
}