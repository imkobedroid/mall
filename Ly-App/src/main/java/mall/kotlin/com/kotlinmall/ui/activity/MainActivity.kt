package mall.kotlin.com.kotlinmall.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kotlin.provider.common.start
import kotlinx.android.synthetic.main.activity_main.*
import mall.kotlin.com.kotlinmall.R

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn.setOnClickListener {
            start()
        }
    }
}
