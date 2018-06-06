package mall.kotlin.com.goodcenter.ui.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import android.widget.PopupWindow
import com.eightbitlab.rxbus.Bus
import com.eightbitlab.rxbus.registerInBus
import com.kotlin.goods.data.protocol.Goods
import com.youth.banner.BannerConfig
import com.youth.banner.Transformer
import kotlinx.android.synthetic.main.fragment_goods_detail_tab_one.*
import mall.kotlin.com.baselibrary.ui.activity.BaseActivity
import mall.kotlin.com.baselibrary.ui.fragment.BaseMvpFragment
import mall.kotlin.com.baselibrary.utils.YuanFenConverter
import mall.kotlin.com.baselibrary.widgets.BannerImageLoader
import mall.kotlin.com.goodcenter.R
import mall.kotlin.com.goodcenter.common.GoodConstant
import mall.kotlin.com.goodcenter.event.GoodsDetailImageEvent
import mall.kotlin.com.goodcenter.event.SkuChangedEvent
import mall.kotlin.com.goodcenter.injection.component.DaggerCategoryComponent
import mall.kotlin.com.goodcenter.injection.module.CategoryModule
import mall.kotlin.com.goodcenter.presenter.GoodsPresenter
import mall.kotlin.com.goodcenter.presenter.view.GoodsView
import mall.kotlin.com.goodcenter.widgets.GoodsSkuPopView

/**
 * @author Dsh  on 2018/6/4.
 */
class GoodsTabOneFragment : BaseMvpFragment<GoodsPresenter>(), GoodsView {


    private val mSkuViewPop: GoodsSkuPopView by lazy { GoodsSkuPopView(activity) }
    //SKU弹层出场动画
    private lateinit var mAnimationStart: Animation
    //SKU弹层退场动画
    private lateinit var mAnimationEnd: Animation
    override fun onGetGoodsResult(result: MutableList<Goods>?) {
    }

    override fun getGoodsDetail(goods: Goods) {
        mGoodsDetailBanner.setImages(goods.goodsBanner.split(",")).start()
        mGoodsDescTv.text = goods.goodsDesc
        mGoodsPriceTv.text = YuanFenConverter.changeF2YWithUnit(goods.goodsDefaultPrice)
        mSkuSelectedTv.text = goods.goodsDefaultSku
        Bus.send(GoodsDetailImageEvent(goods.goodsDetailOne, goods.goodsDetailTwo))
        loadPopData(goods)

    }

    private fun loadPopData(goods: Goods) {
        mSkuViewPop.setGoodsIcon(goods.goodsDefaultIcon)
        mSkuViewPop.setGoodsPrice(goods.goodsDefaultPrice)
        mSkuViewPop.setGoodsCode(goods.goodsCode)
        mSkuViewPop.setSkuData(goods.goodsSku)
    }

    override fun injectComponent() {
        DaggerCategoryComponent.builder().activityComponent(mActivityComponent)
                .categoryModule(CategoryModule()).build().inject(this)
        mPresenter.mView = this
    }


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater?.inflate(R.layout.fragment_goods_detail_tab_one, container, false)
    }


    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAnim()
        initView()
        initSkuPop()
        initData()
        initObserver()
    }

    private fun initSkuPop() {
        mSkuViewPop.setOnDismissListener{
            (activity as BaseActivity).contentView.startAnimation(mAnimationEnd)
        }
    }

    private fun initView() {
        mGoodsDetailBanner.setImageLoader(BannerImageLoader())
                .setBannerAnimation(Transformer.Accordion)
                .setDelayTime(2000).setIndicatorGravity(BannerConfig.RIGHT)

        mSkuView.setOnClickListener {
            mSkuViewPop.showAtLocation((activity as BaseActivity).contentView,Gravity.BOTTOM and Gravity.CENTER_HORIZONTAL,0,0)
            (activity as  BaseActivity).contentView.startAnimation(mAnimationStart)
        }
    }

    private fun initData() {
        mPresenter.getGoodsDetails(activity.intent.getIntExtra(GoodConstant.KEY_GOODS_ID, 0))
    }

    @SuppressLint("SetTextI18n")
    private fun initObserver(){
        Bus.observe<SkuChangedEvent>().subscribe {
            mSkuSelectedTv.text=mSkuViewPop.getSelectSku()+GoodConstant.SKU_SEPARATOR+mSkuViewPop.getSelectCount()+"件"
        }.registerInBus(this)
    }


    override fun onDestroy() {
        super.onDestroy()
        Bus.unregister(this)
    }

    /*
    初始化缩放动画
 */
    private fun initAnim() {
        mAnimationStart = ScaleAnimation(
                1f, 0.95f, 1f, 0.95f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f)
        mAnimationStart.duration = 500
        mAnimationStart.fillAfter = true

        mAnimationEnd = ScaleAnimation(
                0.95f, 1f, 0.95f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f)
        mAnimationEnd.duration = 500
        mAnimationEnd.fillAfter = true
    }

}