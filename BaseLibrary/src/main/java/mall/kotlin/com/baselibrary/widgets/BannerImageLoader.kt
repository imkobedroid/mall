package mall.kotlin.com.baselibrary.widgets

import android.content.Context
import android.widget.ImageView
import com.youth.banner.loader.ImageLoader
import mall.kotlin.com.baselibrary.utils.GlideUtils

/**
 * @author Dsh  on 2018/5/24.
 */
class BannerImageLoader : ImageLoader() {
    override fun displayImage(context: Context, path: Any, imageView: ImageView) {
        GlideUtils.loadUrlImage(context, path.toString(), imageView)
    }
}