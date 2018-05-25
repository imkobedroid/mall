package mall.kotlin.com.kotlinmall.ui.adapter

import android.content.Context

import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.layout_topic_item.view.*
import mall.kotlin.com.baselibrary.ext.loadUrl
import mall.kotlin.com.kotlinmall.R

/**
 * @author Dsh  on 2018/5/25.
 */
class TopicAdapter(private val context: Context, private val list: List<String>) : PagerAdapter() {
    override fun isViewFromObject(view: View?, `object`: Any?): Boolean {
        return view===view
    }

    override fun getCount(): Int {
        return list.size
    }


    override fun destroyItem(container: ViewGroup?, position: Int, `object`: Any?) {
        super.destroyItem(container, position, `object`)
        container?.removeView(`object` as View)
    }


    override fun instantiateItem(container: ViewGroup?, position: Int): Any {
        val rooView = LayoutInflater.from(this.context).inflate(R.layout.layout_topic_item, null)
        rooView.mTopicIv.loadUrl(list[position])
        container?.addView(rooView)
        return rooView
    }


}