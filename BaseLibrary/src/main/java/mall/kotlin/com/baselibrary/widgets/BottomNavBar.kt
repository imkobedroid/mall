package mall.kotlin.com.baselibrary.widgets

import android.content.Context
import android.util.AttributeSet
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.ashokvarma.bottomnavigation.BottomNavigationItem
import com.ashokvarma.bottomnavigation.ShapeBadgeItem
import com.ashokvarma.bottomnavigation.TextBadgeItem
import mall.kotlin.com.baselibrary.R

/**
 * @author Dsh  on 2018/5/24.
 */
class BottomNavBar @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : BottomNavigationBar(context, attrs, defStyleAttr) {


    private val  mCartBadge:TextBadgeItem
    private val  mMsgBadge:ShapeBadgeItem

    init {
        val homeItem = BottomNavigationItem(R.drawable.btn_nav_home_press, resources.getString(R.string.nav_bar_home))
                .setInactiveIconResource(R.drawable.btn_nav_home_normal)
                .setActiveColorResource(R.color.common_blue).setInActiveColorResource(R.color.text_normal)
        val categoryItem = BottomNavigationItem(R.drawable.btn_nav_category_press, resources.getString(R.string.nav_bar_home))
                .setInactiveIconResource(R.drawable.btn_nav_category_normal)
                .setActiveColorResource(R.color.common_blue).setInActiveColorResource(R.color.text_normal)
        val carItem = BottomNavigationItem(R.drawable.btn_nav_cart_press, resources.getString(R.string.nav_bar_home))
                .setInactiveIconResource(R.drawable.btn_nav_cart_normal)
                .setActiveColorResource(R.color.common_blue).setInActiveColorResource(R.color.text_normal)

        mCartBadge= TextBadgeItem()
        carItem.setBadgeItem(mCartBadge)
        mCartBadge.setText("10")

        val msgItem = BottomNavigationItem(R.drawable.btn_nav_msg_press, resources.getString(R.string.nav_bar_home))
                .setInactiveIconResource(R.drawable.btn_nav_msg_normal)
                .setActiveColorResource(R.color.common_blue).setInActiveColorResource(R.color.text_normal)

        mMsgBadge= ShapeBadgeItem()
        mMsgBadge.setShape(ShapeBadgeItem.SHAPE_OVAL)
        msgItem.setBadgeItem(mMsgBadge)

        val userItem = BottomNavigationItem(R.drawable.btn_nav_user_press, resources.getString(R.string.nav_bar_home))
                .setInactiveIconResource(R.drawable.btn_nav_user_normal)
                .setActiveColorResource(R.color.common_blue).setInActiveColorResource(R.color.text_normal)

        setMode(BottomNavigationBar.MODE_FIXED)
        setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC)
        setBarBackgroundColor(R.color.common_white)


        addItem(homeItem)
                .addItem(categoryItem)
                .addItem(carItem)
                .addItem(msgItem)
                .addItem(userItem)
                .setFirstSelectedPosition(0)
                .initialise()
    }

    fun checkCartBadge(count:Int){
        if (count==0){
            mCartBadge.hide()
        }else{
            mCartBadge.show()
            mCartBadge.setText(count.toString())
        }
    }



    fun checkMsgBadge(b:Boolean){
       if (b)mMsgBadge.show() else mMsgBadge.hide()
    }
}