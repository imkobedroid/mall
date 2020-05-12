package mall.kotlin.com.baselibrary.presenter.view

/**
 * @author Dsh  imkobedroid@gmail.com
 * @date 2020/5/12
 */
interface BaseView {

    fun showLoading()
    fun hideLoading()
    fun showError(message:String)
}