package mall.kotlin.com.baselibrary.widgets

import android.text.Editable
import android.text.TextWatcher

/**
 * @author Dsh  on 2018/5/10.
 */
open class DefaultTextWatcher: TextWatcher {
    override fun afterTextChanged(s: Editable?) {
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
    }
}