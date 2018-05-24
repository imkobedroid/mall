package mall.kotlin.com.kotlinmall.ui.fragment

import android.Manifest
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tbruyelle.rxpermissions2.RxPermissions
import com.youth.banner.Banner
import com.youth.banner.BannerConfig
import com.youth.banner.Transformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import mall.kotlin.com.baselibrary.ui.fragment.BaseFragment
import mall.kotlin.com.baselibrary.widgets.BannerImageLoader
import mall.kotlin.com.kotlinmall.R
import mall.kotlin.com.kotlinmall.common.HOME_BANNER_FOUR
import mall.kotlin.com.kotlinmall.common.HOME_BANNER_ONE
import mall.kotlin.com.kotlinmall.common.HOME_BANNER_THREE
import mall.kotlin.com.kotlinmall.common.HOME_BANNER_TWO

/**
 * @author Dsh  on 2018/5/24.
 */
class HomeFragment : BaseFragment() {


    private lateinit var mHomeBanner:Banner
    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater?.inflate(R.layout.fragment_home, null)
        initView(view!!)
        return view
    }

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    private fun initView(view:View) {

        val rxPermission=RxPermissions(activity)
        rxPermission.request(Manifest.permission.INTERNET,Manifest.permission.READ_EXTERNAL_STORAGE)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe {  mHomeBanner=view.findViewById(R.id.mHomeBanner)
            mHomeBanner.setImageLoader(BannerImageLoader())
                    .setImages(arrayListOf(HOME_BANNER_ONE, HOME_BANNER_TWO, HOME_BANNER_THREE, HOME_BANNER_FOUR))
                    .setBannerAnimation(Transformer.Accordion)
                    .setDelayTime(2000).setIndicatorGravity(BannerConfig.RIGHT)
                    .start() }

    }

}