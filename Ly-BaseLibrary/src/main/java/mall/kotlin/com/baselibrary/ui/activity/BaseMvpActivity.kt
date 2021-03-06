package mall.kotlin.com.baselibrary.ui.activity

import android.os.Bundle
import mall.kotlin.com.baselibrary.common.BaseApplication
import mall.kotlin.com.baselibrary.injection.component.ActivityComponent
import mall.kotlin.com.baselibrary.injection.component.DaggerActivityComponent
import mall.kotlin.com.baselibrary.injection.module.ActivityModule
import mall.kotlin.com.baselibrary.injection.module.LifecycleProviderModule
import mall.kotlin.com.baselibrary.presenter.BasePresenter
import mall.kotlin.com.baselibrary.presenter.view.BaseView
import mall.kotlin.com.baselibrary.widgets.ProgressLoading
import org.jetbrains.anko.toast
import javax.inject.Inject

/**
 * @author Dsh  imkobedroid@gmail.com
 * @date 2020/5/12
 */
abstract class BaseMvpActivity<T : BasePresenter<*>> : BaseActivity(), BaseView {
    lateinit var activityComponent: ActivityComponent

    @Inject
    lateinit var mPresenter: T



    private lateinit var mLoadingDialog:ProgressLoading

    override fun showLoading() {
        mLoadingDialog.showLoading()
    }

    override fun hideLoading() {
        mLoadingDialog.hideLoading()
    }

    override fun showError(message:String) {
       toast(message)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initActivityInjection()
        injectComponent()

        mLoadingDialog=ProgressLoading.create(this)
    }

    abstract fun injectComponent()

    private fun initActivityInjection() {
        activityComponent = DaggerActivityComponent.builder()
                .appComponent((application as BaseApplication).appComponent)
                .activityModule(ActivityModule(this))
                .lifecycleProviderModule(LifecycleProviderModule(this))
                .build()

    }
}