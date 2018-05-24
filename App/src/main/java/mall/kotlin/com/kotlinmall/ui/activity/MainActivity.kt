package mall.kotlin.com.kotlinmall.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import mall.kotlin.com.kotlinmall.R
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottom_navigation_bar.checkCartBadge(10)
        bottom_navigation_bar.checkMsgBadge(false)


        Flowable.timer(2, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    bottom_navigation_bar.checkCartBadge(20)
                    bottom_navigation_bar.checkMsgBadge(true)
                })
    }
}
