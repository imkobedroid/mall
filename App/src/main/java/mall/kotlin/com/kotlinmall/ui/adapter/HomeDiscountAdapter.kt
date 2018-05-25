package mall.kotlin.com.kotlinmall.ui.adapter

import android.content.Context
import android.graphics.Paint
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.layout_home_discount_item.view.*
import mall.kotlin.com.baselibrary.ui.adapter.BaseRecyclerViewAdapter
import mall.kotlin.com.baselibrary.utils.GlideUtils
import mall.kotlin.com.kotlinmall.R

/**
 * @author Dsh  on 2018/5/24.
 */
class HomeDiscountAdapter( context:Context): BaseRecyclerViewAdapter<String, HomeDiscountAdapter.viewHolder>(context) {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): viewHolder {

        val view=LayoutInflater.from(mContext).inflate(R.layout.layout_home_discount_item,parent,false)
        return viewHolder(view)
    }

    class viewHolder(view: View):RecyclerView.ViewHolder(view){
     init {
         view.mDiscountBeforeTv.paint.flags=Paint.STRIKE_THRU_TEXT_FLAG
          view.mDiscountBeforeTv.paint.isAntiAlias=true
     }
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        GlideUtils.loadUrlImage(mContext,dataList[position],holder.itemView.mGoodsIconIv)
        holder.itemView.mDiscountAfterTv.text="123元"
        holder.itemView.mDiscountBeforeTv.text="1000元"
    }

}