package mall.kotlin.com.baselibrary.ext

import android.graphics.drawable.AnimationDrawable
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.kennyc.view.MultiStateView
import com.trello.rxlifecycle2.LifecycleProvider
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import mall.kotlin.com.baselibrary.R
import mall.kotlin.com.baselibrary.data.protocol.BaseResp
import mall.kotlin.com.baselibrary.rx.BaseFunc
import mall.kotlin.com.baselibrary.rx.BaseFuncBoolean
import mall.kotlin.com.baselibrary.rx.BaseSubscribe
import mall.kotlin.com.baselibrary.utils.GlideUtils
import mall.kotlin.com.baselibrary.widgets.DefaultTextWatcher
import org.jetbrains.anko.find

/**
 * @author Dsh  on 2018/4/12.
 */
fun <T> Flowable<T>.execute(subscribe: BaseSubscribe<T>, lifecycleProvider: LifecycleProvider<*>) {
    this.subscribeOn(Schedulers.io())
            .compose(lifecycleProvider.bindToLifecycle())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(subscribe)
}


fun View.onClick(onClickListener: View.OnClickListener) {
    this.setOnClickListener(onClickListener)
}


/**
 * 传入一个lambda表达式来进行扩展(只需要关心你执行的方法)
 */
fun View.onClick(method: () -> Boolean) {
    this.setOnClickListener { method }
}


/**
 * 监听文本变化 让button变色
 */
fun Button.enable(edt: EditText, method: () -> Boolean) {
    val btn = this
    edt.addTextChangedListener(object : DefaultTextWatcher() {
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            btn.isEnabled = method()
        }
    })
}



/*
扩展数据转换
*/
fun <T> Flowable<BaseResp<T>>.convert(): Flowable<T> {
    return this.flatMap(BaseFunc())
}

/*
    扩展Boolean类型数据转换
 */
fun <T> Flowable<BaseResp<T>>.convertBoolean(): Flowable<Boolean> {
    return this.flatMap(BaseFuncBoolean())
}


/*
    ImageView加载网络图片
 */
fun ImageView.loadUrl(url: String) {
    GlideUtils.loadUrlImage(context, url, this)
}


fun View.setVisible(b: Boolean) {
    if (b) this.visibility = View.VISIBLE else this.visibility = View.GONE
}

/*
    多状态视图开始加载
 */
fun MultiStateView.startLoading() {
    viewState = MultiStateView.VIEW_STATE_LOADING
    val loadingView = getView(MultiStateView.VIEW_STATE_LOADING)
    val animBackground = loadingView!!.find<View>(R.id.loading_anim_view).background
    (animBackground as AnimationDrawable).start()
}