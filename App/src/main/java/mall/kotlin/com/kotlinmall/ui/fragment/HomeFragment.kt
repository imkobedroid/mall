package mall.kotlin.com.kotlinmall.ui.fragment

import android.Manifest
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tbruyelle.rxpermissions2.RxPermissions
import com.youth.banner.BannerConfig
import com.youth.banner.Transformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_home.*
import mall.kotlin.com.baselibrary.ui.fragment.BaseFragment
import mall.kotlin.com.baselibrary.widgets.BannerImageLoader
import mall.kotlin.com.goodcenter.ui.activity.SearchGoodsActivity
import mall.kotlin.com.kotlinmall.R
import mall.kotlin.com.kotlinmall.common.*
import mall.kotlin.com.kotlinmall.ui.adapter.HomeDiscountAdapter
import mall.kotlin.com.kotlinmall.ui.adapter.TopicAdapter
import me.crosswall.lib.coverflow.CoverFlow
import org.jetbrains.anko.support.v4.startActivity

/**
 * @author Dsh  on 2018/5/24.
 */
class HomeFragment : BaseFragment() {


    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater?.inflate(R.layout.fragment_home, null)
    }


    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initTopic()
    }

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    private fun initView() {


        mSearchEt.setOnClickListener { startActivity<SearchGoodsActivity>() }

        newsFlipperView.setData(arrayOf("夏日炎炎，第一波福利还有30秒到达战场\", \"新用户立领1000元优惠券"))

        val rxPermission = RxPermissions(activity)
        rxPermission.request(Manifest.permission.INTERNET, Manifest.permission.READ_EXTERNAL_STORAGE)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe {
                    mHomeBanner.setImageLoader(BannerImageLoader())
                            .setImages(arrayListOf(HOME_BANNER_ONE, HOME_BANNER_TWO, HOME_BANNER_THREE, HOME_BANNER_FOUR))
                            .setBannerAnimation(Transformer.Accordion)
                            .setDelayTime(2000).setIndicatorGravity(BannerConfig.RIGHT)
                            .start()
                }

        initDiscount()
    }

    private fun initDiscount() {
        val manager = LinearLayoutManager(activity)
        manager.orientation = LinearLayoutManager.HORIZONTAL
        mHomeDiscountRv.layoutManager = manager
        val discountAdapter = HomeDiscountAdapter(activity)
        mHomeDiscountRv.adapter = discountAdapter
        discountAdapter.setData(mutableListOf(HOME_DISCOUNT_ONE, HOME_DISCOUNT_TWO, HOME_DISCOUNT_THREE, HOME_DISCOUNT_FOUR, HOME_DISCOUNT_FIVE))
    }


    /*
       初始化主题
    */
    private fun initTopic() {
        //话题
        mTopicPager.adapter = TopicAdapter(context, listOf(HOME_TOPIC_ONE, HOME_TOPIC_TWO, HOME_TOPIC_THREE, HOME_TOPIC_FOUR, HOME_TOPIC_FIVE))
        mTopicPager.currentItem = 1
        mTopicPager.offscreenPageLimit = 5

        CoverFlow.Builder().with(mTopicPager).scale(0.3f).pagerMargin(-30.0f).spaceSize(0.0f).build()
    }

}