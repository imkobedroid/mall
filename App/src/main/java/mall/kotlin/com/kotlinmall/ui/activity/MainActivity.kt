package mall.kotlin.com.kotlinmall.ui.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import mall.kotlin.com.kotlinmall.R
import mall.kotlin.com.kotlinmall.ui.fragment.HomeFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottom_navigation_bar.checkCartBadge(10)
        bottom_navigation_bar.checkMsgBadge(false)
  initView()

    }

    @SuppressLint("CommitTransaction")
    private fun initView() {
        val manage=supportFragmentManager.beginTransaction()
        manage.replace(R.id.frame_layout,HomeFragment())
        manage.commit()
    }
}
