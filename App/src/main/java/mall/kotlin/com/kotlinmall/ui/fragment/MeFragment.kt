package mall.kotlin.com.kotlinmall.ui.fragment

import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kotlin.provider.common.ProviderConstant
import com.kotlin.provider.common.isLogin
import com.kotlin.usercenter.ui.LoginActivity
import com.kotlin.usercenter.ui.UserInfoActivity
import kotlinx.android.synthetic.main.fragment_me.*
import mall.kotlin.com.baselibrary.ext.loadUrl
import mall.kotlin.com.baselibrary.ui.fragment.BaseFragment
import mall.kotlin.com.baselibrary.utils.AppPrefsUtils
import mall.kotlin.com.kotlinmall.R
import mall.kotlin.com.kotlinmall.ui.activity.SettingActivity
import org.jetbrains.anko.support.v4.startActivity

/**
 * @author Dsh  on 2018/5/24.
 */
class MeFragment : BaseFragment(),View.OnClickListener {



    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater?.inflate(R.layout.fragment_me, null)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        mUserIconIv.setOnClickListener(this)
        mUserNameTv.setOnClickListener(this)
        mSettingTv.setOnClickListener(this)
    }

    override fun onStart() {
        super.onStart()
        loadDate()
    }

    private fun loadDate() {
        if (!isLogin()){
            mUserIconIv.setImageResource(R.drawable.icon_default_user)
            mUserNameTv.text="登陆/注册"

        }else{
         val userIcon=AppPrefsUtils.getString(ProviderConstant.KEY_SP_USER_ICON)
            if(userIcon.isNotEmpty()){
                mUserIconIv.loadUrl(userIcon)
                mUserNameTv.text=AppPrefsUtils.getString(ProviderConstant.KEY_SP_USER_NAME)
            }
        }
    }
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.mUserIconIv,R.id.mUserNameTv ->{
                if(isLogin()){
                    startActivity<UserInfoActivity>()
                }else{
                    startActivity<LoginActivity>()
                }
            }
            R.id.mSettingTv ->{startActivity<SettingActivity>()}
        }
    }


}