package mall.kotlin.com.kotlinmall.ui.activity

import android.annotation.SuppressLint
import android.os.Bundle
import com.kotlin.usercenter.utils.UserPrefsUtils
import kotlinx.android.synthetic.main.activity_setting.*
import mall.kotlin.com.baselibrary.ui.activity.BaseActivity
import mall.kotlin.com.kotlinmall.R

@SuppressLint("Registered")
/**
 * @author Dsh  on 2018/5/25.
 */
class SettingActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)
        initView()
    }

    private fun initView() {
        mLogoutBtn.setOnClickListener {
            UserPrefsUtils.putUserInfo(null)
            finish()
        }
    }


}